package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto.Proyecto;

import java.io.Serializable;

public class ListarPersonasProyecto  implements Serializable {

    public static void ejecutaListarPersonasProyecto(Proyecto proyecto){

        System.out.println("\nEsta es la lista de personas");

        System.out.println(proyecto.listarPersonas());
        System.out.format("\n");

    }
}
