package Aplicacion.EjecutarMétodos;

import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.util.Scanner;

public class EliminarPersonaTarea {

    public static void ejecutaEliminarPersonaTarea(Scanner sn , Proyecto proyecto){

        System.out.format("Introduce el título de la tarea --> ");


        String titulo = sn.next();

        Tareas tarea = proyecto.getTarea(titulo);

        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona = proyecto.getPersona(dni);

        System.out.println(tarea.eliminarPersonaTarea(persona));
        System.out.format("\n");
    }
}
