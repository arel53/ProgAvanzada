package Aplicacion.EjecutarMétodos;

import Aplicacion.Fecha;
import Aplicacion.Personas;
import Aplicacion.Proyecto;
import Aplicacion.Tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AltaTareas {


    public static void ejecutaAltaTareas(Scanner sn, Proyecto proyecto) {

        List<Tareas> tareas = new ArrayList<>();
        List<Personas> personas = new ArrayList<>();
        List<String> etiquetas = new ArrayList<>();

        System.out.format("\nVas a introducir la tarea :");

        System.out.format("Introduce el título --> ");
        String titulo = sn.next();
        System.out.format("\nIntroduce la descripción --> ");
        String descrip = sn.next();
        System.out.format("Vas a introducir las personas que realizan esta tarea (si has terminado introduce la letra q): \n");

        int contador = 1;
        while (true) {

            System.out.format("El dni de la persona nº(" + (contador++) + ") es --> ");
            String dni = sn.next();
            if (dni.equals("q"))
                break;
            personas.add(proyecto.getPersona(dni));
        }

        System.out.format("\nIntroduce el DNI de la persona responsable --> ");

        Personas personaResponsable = proyecto.getPersona(sn.next());

        System.out.format("\nIntroduce la prioridad (entero) --> ");

        int prioridad = sn.nextInt();

        Fecha fechaCreacion = Fecha.fechaActual();

        Fecha finalizacion = new Fecha();

        System.out.format("Indica el resultado esperado --> ");

        String resultado = sn.next();

        System.out.format("Indica la etiqueta que quieres añadir (q si has terminado) --> ");

        contador = 1;
        while (true) {
            System.out.format("Etiqueta nº(" + (contador++) + ") --> ");
            String etiqueta = sn.next();
            if(etiqueta.equals("q"))
                break;
            etiquetas.add(etiqueta);
        }

        Tareas tarea = Tareas.createTarea(titulo,descrip,personas,personaResponsable,prioridad,fechaCreacion,finalizacion,resultado,etiquetas);
        proyecto.altaTarea(tarea);
        personaResponsable.addPersonaTareas(tarea);
        System.out.format("\n");

    }
}
