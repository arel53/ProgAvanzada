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


    public String altaPersona(Personas persona){
            personas.add(persona);
            return "Se ha añadido la persona";
    }


    public boolean altaTarea(Tareas tarea){
        if(!tareas.contains(tarea)) {
            tareas.add(tarea);
            return true;
        }
        return false;
    }




    public List<Personas> ListarPersonas(){
        return personas;
    }

    public List<Tareas> listarTareas(){
        return tareas;
    }


    }
