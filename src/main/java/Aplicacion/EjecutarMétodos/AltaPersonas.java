package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;

import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

public class AltaPersonas {


    public static void ejecutarAltaPersonas (Scanner sn, Proyecto proyecto){



        System.out.format("\nVas a dar de alta a personas que trabajan en el proyecto\n");
        System.out.format("\nIntorduce el nombre de la persona y sus datos (DNI,nombre, correo y sus tareas) respectivamente: \n");
        System.out.format("\nIntroduce el DNI --> ");


        String dni = sn.next().toUpperCase();

        System.out.format("\nIntroduce el nombre --> ");
        sn.nextLine();
        String nombre = sn.nextLine();
        System.out.format("\nIntroduce el correo --> ");
        String correo = sn.next();

        try {
        if (UtilidadesParaListas.insertarEnLista(dni, proyecto.listarPersonas())) {
            proyecto.altaPersona(Personas.createPersona(dni, nombre, correo));

            System.out.println("Se ha añadido correctamente a --> " + nombre);
        }
        else
            throw new PersonaNoAñadida();


    } catch (PersonaNoAñadida e){

            System.out.format("\nNo se añadió a %s, consulta que no esté añadida ya \n", nombre);
    }


        sn.nextLine();
        System.out.format("\n");
    }
}