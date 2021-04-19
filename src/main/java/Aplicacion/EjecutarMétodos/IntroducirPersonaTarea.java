package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaExistente;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.util.Scanner;

public class IntroducirPersonaTarea {

    public static void ejectaIntroducirPersonaTarea(Scanner sn , Proyecto proyecto){
        sn.nextLine();


        System.out.format("\nIntroduce el título de la tarea --> ");


        String titulo = sn.nextLine();
        Tareas tarea = proyecto.getTarea(titulo);

        try {

            if(proyecto.getTarea(titulo) == null) {
                throw new TareaNoExistente();
            }


        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona;

            persona = proyecto.getPersona(dni);
            if(persona == null){
                throw new PersonaNoExistente();
            }
            if (!UtilidadesParaListas.insertarEnLista(persona,tarea.getLista()))
                throw new PersonaExistente();
            else
                System.out.println(tarea.introducirPersonaTarea(persona));


        }catch (PersonaExistente e2){
            System.out.format("La persona ya existía\n");
        }
        catch (TareaNoExistente e1){
            System.out.format("La tarea no existe\n");
        }
        catch (PersonaNoExistente e3){
            System.out.format("La persona no existe en el proyecto");
        }

        System.out.format("\n");


    }
}
