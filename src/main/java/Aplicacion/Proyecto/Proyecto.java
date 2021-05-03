package Aplicacion.Proyecto;

import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public class Proyecto implements Serializable{
    private static final long serialVersionUID=42L;
    String nombre;
    List<Personas> personas;
    List<Tareas> tareas;

    public Proyecto(String nombre){
        this.nombre = nombre.toLowerCase();
        this.personas = new LinkedList<>();
        this.tareas = new LinkedList<>();
    }

    public Proyecto(){
        personas = new LinkedList<>();
        tareas = new LinkedList<>();
    }

    public String toString(){
        return "Proyecto --> " + nombre;
    }

    public static Proyecto iniciarProyecto(String nombre){
        return new Proyecto(nombre);
    }

    public void altaPersona(Personas persona){
        personas.add(persona);
    }

    public boolean altaTarea(Tareas tarea){
        tarea.getResponsable().addPersonaTareas(tarea);
        return tareas.add(tarea);
    }


    public List<Personas> listarPersonas(){
        return personas;
    }

    public List<Tareas> listarTareas(){
        return tareas;
    }

    public Personas getPersona(String dni){

        for (Personas p : personas){
            if (p.getDni().equals(dni.toLowerCase())){
                return p;
            }
        }

        return null;
    }

    public Tareas getTarea(String tarea){

        for (Tareas t : tareas){
            if (t.getClave().equals(tarea.toLowerCase()))
                return t;
        }
        return null;
    }

    public String getNombre(){
        return nombre;
    }


}
