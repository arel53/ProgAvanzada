package Aplicacion.EjecutarMétodos;

import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;

import java.util.Scanner;

public class BajaPersona {

    public static void ejecutaBajaPersona(Scanner sn , Proyecto proyecto){
        System.out.format("\nEscribe el dni de la persona que vas a eliminar --> ");
        String dni = sn.next();

        Personas persona = proyecto.getPersona(dni);

        proyecto.bajaPersona(persona);

        System.out.format("\nSe ha dado de baja a la persona del proyecto correctamente\n");
    }
}
