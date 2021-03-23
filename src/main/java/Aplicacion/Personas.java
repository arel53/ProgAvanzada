package Aplicacion;

import java.util.List;

public class Personas {

    public String nombre;
    public String correo;
    public List<Tareas> tareas;


    public Personas(String nombre, String correo, List<Tareas> tareas){
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = tareas;


    }

    public String toString(){
        return "Nombre :"+ nombre;
    }




}
