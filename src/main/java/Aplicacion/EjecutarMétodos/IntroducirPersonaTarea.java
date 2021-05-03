package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaExistente;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.Scanner;

public class IntroducirPersonaTarea{

    public static void ejectaIntroducirPersonaTarea(Scanner sn , Proyecto proyecto) throws TareaNoExistente {
        sn.nextLine();


        System.out.format("\nIntroduce el título de la tarea --> ");


        String titulo = sn.nextLine();
        Tareas tarea = proyecto.getTarea(titulo);

        try {

            proyecto.getTarea(titulo);


        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona;

            persona = proyecto.getPersona(dni);
            if(persona == null){
                throw new PersonaNoExistente("\nLa persona no existe en el proyecto");
            }
            if (!UtilidadesParaListas.insertarEnLista(dni,tarea.getLista()))
                throw new PersonaExistente("\nLa persona ya existía");
            else {
                tarea.introducirPersonaTarea(persona);
                System.out.format("\nSe ha añadido correctamente a la persona en la tarea");
            }


        }catch (PersonaExistente | TareaNoExistente | PersonaNoExistente e){
            System.out.format(e.getMessage());
        }

        System.out.format("\n");


    }
}
