package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.*;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AltaTareas {


        public static void ejecutaAltaTareas(Scanner sn, Proyecto proyecto) {

            List<Personas> personas = new LinkedList<>();
            List<String> etiquetas = new LinkedList<>();

            System.out.format("\nVas a introducir la tarea :");

            System.out.format("Introduce el título --> ");
            String titulo = sn.nextLine();
            System.out.format("\nIntroduce la descripción --> ");
            String descrip = sn.nextLine();
            System.out.format("\nVas a introducir las personas que realizan esta tarea (si has terminado introduce la letra q): \n");

            int contador = 1;
            while (true) {

                System.out.format("\nEl dni de la persona nº(" + (contador++) + ") es --> ");
                String dni = sn.next();
                if (dni.equals("q"))
                    break;
                personas.add(proyecto.getPersona(dni));
            }

            System.out.format("\nIntroduce el DNI de la persona responsable --> ");

            Personas personaResponsable = proyecto.getPersona(sn.next());

            System.out.format("\nIntroduce la prioridad (entero) --> ");

            int prioridad = sn.nextInt();

            System.out.format("\nIndica el resultado esperado \n1. Documentación\n2. Programa\n3. Biblioteca\n4. Pag. Web--> ");

            int opcion = sn.nextInt();
            Resultado resultado;
            if (opcion == 1)
                resultado = new Documentacion();
            else if (opcion == 2)
                resultado = new Programa();

            else if (opcion == 3)
                resultado = new Biblioteca();
            else
                resultado = new PagWeb();

            System.out.format("\nIndica la etiqueta que quieres añadir (q si has terminado) --> ");
            sn.nextLine();

            contador = 1;
            while (true) {
                System.out.format("\nEtiqueta nº(" + (contador++) + ") --> ");
                String etiqueta = sn.next();
                if(etiqueta.equals("q"))
                    break;
                etiquetas.add(etiqueta);

            }
            Tareas tarea = Tareas.createTarea(titulo,descrip,personas,personaResponsable,prioridad,resultado,etiquetas);
            try {
                if (UtilidadesParaListas.insertarEnLista(titulo,proyecto.listarTareas())){
                    proyecto.altaTarea(tarea);
                    personaResponsable.addPersonaTareas(tarea);

                }
                else throw new TareaExistente();

            }catch (TareaExistente e){

                System.out.format("\nLa tarea %s ya existía y no se ha añadido ", titulo);

            }

            sn.nextLine();
            System.out.format("\n");



        }
    }
