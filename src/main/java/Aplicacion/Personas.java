package Aplicacion;

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

    public String toString(){
        return "Nombre :"+ nombre;
    }




}
