package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto;

import java.util.Scanner;

public class ListarTareasProyecto {

    public static void ejecutaListarTareasProyecto(Proyecto proyecto){
        System.out.println("Esta es la lista de tareas");

        System.out.println(proyecto.listarTareas());
    }
}
