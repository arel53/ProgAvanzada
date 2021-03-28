package Aplicacion;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.List;

public class Personas {

    public String dni;
    public String nombre;
    public String correo;
    public List<Tareas> tareas;


    public Personas(String dni,String nombre, String correo){
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = new ArrayList<>();


    }

    public Personas(){
        tareas = new ArrayList<>();
    }

    public String toString(){
        return "Dni --> " + dni +" Nombre --> "+ nombre;
    }


    public static Personas createPersona(String dni,String nombre, String correo){
        return new Personas(dni.toUpperCase(),nombre,correo);
    }

    public void addPersonaTareas(Tareas tarea){
        this.tareas.add(tarea);
    }

    public String getNombre(){
        return nombre;
    }

    public String getDni(){
        return dni;
    }

    public String getCorreo(){
        return correo;
    }





}
