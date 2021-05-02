package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.*;
import Aplicacion.Tareas.*;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AltaTareas {


    public static void ejecutaAltaTareas(Scanner sn, Proyecto proyecto) {
        sn.nextLine();

        List<Personas> personas = new LinkedList<>();
        List<String> etiquetas = new LinkedList<>();

        System.out.format("\nVas a introducir la tarea :");

        System.out.format("Introduce el título --> ");
        String titulo = sn.nextLine();
        System.out.format("\nIntroduce la descripción --> ");
        String descrip = sn.nextLine();
        System.out.format("\nVas a introducir las personas que realizan esta tarea (si has terminado introduce la letra q): \n");

        int contador = 1;
        Personas p;
        while (true) {

            System.out.format("\nEl dni de la persona nº(" + (contador++) + ") es --> ");
            String dni = sn.next();
            if (dni.equals("q"))
                break;
            try {
                p = proyecto.getPersona(dni);
                if (p != null)
                    if (!personas.contains(p))
                        personas.add(proyecto.getPersona(dni));
                    else throw new PersonaNoAñadida("La persona ya estaba añadida");
                else throw new PersonaNoAñadida();
            } catch (PersonaNoAñadida e) {
                System.out.println(e.getMessage());
            }
        }


            Personas personaResponsable = null;
            while (true) {
                System.out.format("\nIntroduce el DNI de la persona responsable --> ");
                String personaR = sn.next();
                Personas persona = proyecto.getPersona(personaR);

                if (personaR.equals("q"))
                    break;

                try {
                    if (persona == null) {
                        throw new PersonaNoExistente();
                    } else{
                        personaResponsable = proyecto.getPersona(personaR);
                        break;
                    }

                } catch (PersonaNoExistente e1) {
                    System.out.format("\nLa persona no existe.");
                }

            }

            System.out.format("\nIntroduce la prioridad (entero) --> ");
            int prioridad = sn.nextInt();

            System.out.format("\nIntroduce el id del resultado --> ");
            String id = sn.next();

            System.out.format("\nIntroduce el nº de horas invertido en su producción --> ");
            int horas = sn.nextInt();

            System.out.format("\nElija la opcion\n\n(interno) si es resultado interno\n(comercializado) si está destinado a ser comercializado\n--> ");
            String tipo = sn.next();

            System.out.format("\nIndica el resultado esperado \n1. Documentación\n2. Programa\n3. Biblioteca\n4. Pag. Web\n--> ");
            int opcion = sn.nextInt();
            Resultado resultado;

        try {

            if (opcion == 1)
                resultado = new Documentacion(id, horas, tipo);
            else if (opcion == 2)
                resultado = new Programa(id, horas, tipo);

            else if (opcion == 3)
                resultado = new Biblioteca(id, horas, tipo);
            else if (opcion == 4)
                resultado = new PagWeb(id, horas, tipo);
            else throw new IndexOutOfBoundsException();

            System.out.format("\nIndica la etiqueta que quieres añadir (q si has terminado) --> ");
            sn.nextLine();

            contador = 1;
            while (true) {
                System.out.format("\nEtiqueta nº(" + (contador++) + ") --> ");
                String etiqueta = sn.next();
                if (etiqueta.equals("q"))
                    break;
                etiquetas.add(etiqueta);

            }

            System.out.format("\nIntroduce el coste de la tarea --> ");
            double coste = sn.nextDouble();

            System.out.format("\nIntroduce nº según el tipo\n1. Urgente\n2. Consumo interno\n3. Descuento\n--> ");

            opcion = sn.nextInt();

            Facturacion facturacion;

            if (opcion == 1)
                facturacion = new Facturacion(coste, new Urgente());
            else if (opcion == 2)
                facturacion = new Facturacion(coste, new ConsumoInterno());
            else if (opcion == 3)
                facturacion = new Facturacion(coste, new Descuento());
            else
                throw new IndexOutOfBoundsException();


            Tareas tarea = Tareas.createTarea(titulo, descrip, personas, personaResponsable, prioridad, resultado, etiquetas, facturacion.getCalculoFac(), coste, facturacion.calculoFactura(coste));

            if (UtilidadesParaListas.insertarEnLista(titulo, proyecto.listarTareas())) {
                proyecto.altaTarea(tarea);
                personaResponsable.addPersonaTareas(tarea);

            } else throw new TareaExistente();

            System.out.format("\nEl calculo de la facturación es de %1.2f euros", tarea.getFacturacion());

        } catch (TareaExistente e) {

            System.out.format("\nLa tarea %s ya existía y no se ha añadido ", titulo);

        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.format("\nOpción incorrecta");
        }

        sn.nextLine();
        System.out.format("\n");


    }
}
