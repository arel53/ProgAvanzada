package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto;
import Aplicacion.Tareas;

import java.util.Scanner;

public class FinalizarTarea {



    public static void ejecutarFinalizarTarea(Scanner sn, Proyecto proyecto){


        System.out.format("Vas a finalizar una tarea\n");
        System.out.format("Escribe el nombre de la tarea para finalizarla --> ");

        String titulo = sn.next();

        Tareas tarea = proyecto.getTarea(titulo);

        System.out.println(tarea.finalizarTarea());

    }
}
