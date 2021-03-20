package Aplicacion;

import javax.swing.plaf.TreeUI;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    String nombre;
    List<Personas> personas;
    List<Tareas> tareas;

    public Proyecto(String nombre){
        this.nombre = nombre;
        this.personas = new ArrayList<>();
    }
    public Proyecto(){

    }


    public boolean altaPersona(Personas persona){
        if(!personas.contains(persona)) {
            personas.add(persona);
            return true;
        }
        return false;
    }


    public boolean altaTarea(Tareas tarea){
        if(!tareas.contains(tarea)) {
            tareas.add(tarea);
            return true;
        }
        return false;
    }

    public boolean finalizarTarea(Tareas tarea){
        for (Tareas t : tareas){
            if (t.equals(tarea)) {
                t.estado = true;
                return true;
            }
        }
        return false;
    }
    public boolean introducirEliminarPersona(String opcion, Personas persona){
        if(opcion == null)
            return false;
        if(!personas.contains(persona)){

        }
        opcion = opcion.toUpperCase();

        if (opcion.equals("ELIMINAR")){

        }else if (opcion.equals("INTRODUCIR")){

        }
        return false;
        }
    }
