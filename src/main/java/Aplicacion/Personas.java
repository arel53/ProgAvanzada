package Aplicacion;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.List;

public class Personas {

    public String nombre;
    public String correo;
    public List<Tareas> tareas;


    public Personas(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = new ArrayList<>();


    }

    public Personas(){
        tareas = new ArrayList<>();
    }

    public String toString(){
        return "Nombre :"+ nombre;
    }


    public static Personas createPersona(String nombre, String correo){
        return new Personas(nombre,correo);
    }

    public void addPersonaTareas(Tareas tarea){
        this.tareas.add(tarea);
    }






}
