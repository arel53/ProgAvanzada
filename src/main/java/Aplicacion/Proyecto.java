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
        this.tareas = new ArrayList<>();
    }

    public String toString(){
        return "Proyecto --> " + nombre;
    }

    public Proyecto iniciarProyecto(String nombre){
        return new Proyecto(nombre);
    }

    public boolean altaPersona(Personas persona){
        return personas.add(persona);
    }


    public boolean altaTarea(Tareas tarea){
            return tareas.add(tarea);
    }




    public List<Personas> listarPersonas(){
        return personas;
    }

    public List<Tareas> listarTareas(){
        return tareas;
    }

    }
