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

    public static Proyecto iniciarProyecto(String nombre){
        return new Proyecto(nombre);
    }

    public void altaPersona(Personas persona){
        personas.add(persona);
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

    public Personas getPersona(String persona){

        for (Personas p : personas){
            if (p.nombre.equals(persona)){
                return p;
            }
        }

        return new Personas();
    }

    }
