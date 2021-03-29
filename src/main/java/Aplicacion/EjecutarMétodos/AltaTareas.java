package Aplicacion.EjecutarMétodos;

import Aplicacion.Fecha.Fecha;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;
;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AltaTareas {


    public static void ejecutaAltaTareas(Scanner sn, Proyecto proyecto) {

        Set<Personas> personas = new HashSet<>();
        Set<String> etiquetas = new HashSet<>();

        System.out.format("\nVas a introducir la tarea :");

        System.out.format("Introduce el título --> ");
        String titulo = sn.next();
        System.out.format("\nIntroduce la descripción --> ");
        String descrip = sn.next();
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

        Fecha fechaCreacion = Fecha.fechaActual();

        Fecha finalizacion = new Fecha();

        System.out.format("\nIndica el resultado esperado --> ");

        String resultado = sn.next();

        System.out.format("\nIndica la etiqueta que quieres añadir (q si has terminado) --> ");

        contador = 1;
        while (true) {
            System.out.format("\nEtiqueta nº(" + (contador++) + ") --> ");
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
