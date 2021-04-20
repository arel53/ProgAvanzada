package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto.Proyecto;

import java.io.Serializable;

public class ListarTareasProyecto{

    public static void ejecutaListarTareasProyecto(Proyecto proyecto){
        System.out.println("\nEsta es la lista de tareas");

        System.out.println(proyecto.listarTareas());
        System.out.format("\n");
    }
}
