package Aplicacion.Proyecto;

import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;

import java.util.HashSet;
import java.util.Set;

public class Proyecto {

    String nombre;
    Set<Personas> personas;
    Set<Tareas> tareas;

    public Proyecto(String nombre){
        this.nombre = nombre;
        this.personas = new HashSet<>();
        this.tareas = new HashSet<>();
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
            return tareas.add(tarea);
    }


    public Set<Personas> listarPersonas(){
        return personas;
    }

    public Set<Tareas> listarTareas(){
        return tareas;
    }

    public Personas getPersona(String dni){

        for (Personas p : personas){
            if (p.getDni().equals(dni.toUpperCase())){
                return p;
            }
        }

        return new Personas();
    }

    public Tareas getTarea(String tarea){

        for (Tareas t : tareas){
            if (t.getTitulo().equals(tarea.toLowerCase()))
                return t;
        }
        return new Tareas();
    }

    public String getNombre(){
        return nombre;
    }

}


