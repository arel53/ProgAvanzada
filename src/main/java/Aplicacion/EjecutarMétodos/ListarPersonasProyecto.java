package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto.Proyecto;

public class ListarPersonasProyecto {

    public static void ejecutaListarPersonasProyecto(Proyecto proyecto){

        System.out.println("\nEsta es la lista de personas");

        System.out.println(proyecto.listarPersonas());
        System.out.format("\n");

    }
}
