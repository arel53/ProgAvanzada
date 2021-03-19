package Aplicacion;

import java.util.List;

public class Personas {

    private String nombre;
    private String correo;
    private List<Tareas> tareas;


    public Personas(String nombre, String correo, List<Tareas> tareas){
        this.nombre = nombre;
        this.correo = correo;
        this.tareas = tareas;


    }
}
