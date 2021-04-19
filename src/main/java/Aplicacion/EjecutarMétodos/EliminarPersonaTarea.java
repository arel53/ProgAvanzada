package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.util.Scanner;

public class EliminarPersonaTarea {

    public static void ejecutaEliminarPersonaTarea(Scanner sn , Proyecto proyecto){

        System.out.format("Introduce el título de la tarea --> ");


        String titulo = sn.nextLine();

        try {
            Tareas tarea;
            if(proyecto.getTarea(titulo) != null){
                tarea = proyecto.getTarea(titulo);
            }
            else throw new TareaNoExistente();
            System.out.format("\nLa tarea no existe");



        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona = proyecto.getPersona(dni);

            if(!UtilidadesParaListas.insertarEnLista(dni,tarea.getPersonas())){
                tarea.eliminarPersonaTarea(persona);
                System.out.println("Se ha eliminado correctamente");

            }
            else throw new PersonaNoAñadida();
        }
        catch (PersonaNoAñadida | TareaNoExistente e ){
            System.out.format("La persona o la tarea no existen");
        }
        System.out.format("\n");
    }
}
