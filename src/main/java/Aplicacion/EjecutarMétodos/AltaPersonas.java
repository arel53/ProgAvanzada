package Aplicacion.EjecutarMétodos;

import Aplicacion.Personas;
import Aplicacion.Proyecto;
import Aplicacion.Tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AltaPersonas {


    public static void ejecutarAltaPersonas(Scanner sn, Proyecto proyecto){


        System.out.format("\nVas a dar de alta a personas que trabajan en el proyecto");
        System.out.format("\nIntorduce el nombre de la persona y sus datos (nombre, correo y sus tareas) respectivamente: ");
        System.out.format("\nIntroduce el nombre --> ");
        String nombre = sn.next();
        System.out.format("\nIntroduce el correo --> ");
        String correo = sn.next();

        proyecto.altaPersona(Personas.createPersona(nombre,correo));

        System.out.format("\n");
    }
}