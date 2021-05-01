package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.*;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.Scanner;

public class EliminarPersonaTarea{

    public static void ejecutaEliminarPersonaTarea(Scanner sn , Proyecto proyecto){

        System.out.format("Introduce el título de la tarea --> ");


        String titulo = sn.nextLine();

        try {
            Tareas tarea  =  proyecto.getTarea(titulo);

            if(proyecto.getTarea(titulo) == null) {
                throw new TareaNoExistente();
            }



        System.out.format("\nIntroduce el DNI de la persona --> ");

        String dni = sn.next();

        Personas persona = proyecto.getPersona(dni);

        if (tarea.getResponsable().equals(persona)){
            throw new PersonaNoEliminada("La persona no se ha eliminado ya que es la responsable de la tarea");
        }


            if(!UtilidadesParaListas.insertarEnLista(dni,tarea.getLista())){
                if(tarea.eliminarPersonaTarea(persona))
                    System.out.println("Se ha eliminado correctamente");
                else
                    throw new PersonaNoExistente();

            }
            else throw new PersonaNoEliminada("La persona no se ha eliminado ya que no forma parte de la tarea");
        }
        catch (TareaNoExistente | PersonaNoEliminada | PersonaNoExistente e){
            System.out.format(e.getMessage());
        }
        System.out.format("\n");
    }
}
