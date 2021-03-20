package Aplicacion;

import java.util.List;

public class Tareas {

    String titulo;
    String descripcion;
    List<Personas> personas;
    Personas responsable;
    int prioridad;
    Fecha creacion;
    Fecha finalizacion;
    boolean estado;
    String resultado;
    List<String> etiquetas;


    public Tareas(String titulo,String descripcion,List<Personas> personas,Personas responsable, int prioridad, Fecha creacion, Fecha finalizacion,String resultado, List<String> etiquetas){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.personas = personas;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.creacion = creacion;
        this.finalizacion = finalizacion;
        this.estado = false;
        this.resultado = resultado;
        this.etiquetas = etiquetas;
    }

    public Tareas(){

    }



}
