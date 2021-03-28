package Aplicacion.EjecutarMétodos;

import Aplicacion.Proyecto;

import java.util.Scanner;

public class ListarPersonasProyecto {

    public static void ejecutaListarPersonasProyecto(Proyecto proyecto){

        System.out.println("Esta es la lista de personas");

        System.out.println(proyecto.listarPersonas());

    }
}
