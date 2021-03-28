package Aplicacion;

import java.util.List;

public class Tareas {
    Informacion informacion;
    Fecha creacion;
    Fecha finalizacion;
    Participantes participantes;

    public Tareas(String titulo,String descripcion,List<Personas> personas,Personas responsable, int prioridad,String resultado, List<String> etiquetas){

        this.informacion = new Informacion(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
        creacion = Fecha.fechaActual();
        finalizacion = new Fecha();

    }

    public Tareas(){
        informacion = new Informacion();
        participantes = new Participantes();
        creacion = new Fecha();
        finalizacion = new Fecha();
    }


    public String introducirPersonaTarea(Personas persona){
        participantes.personas.add(persona);
        return "Se ha introducido correctamente a "+ persona.nombre;
    }


    public String eliminarPersonaTarea(Personas personas){
        participantes.personas.remove(personas);
        return "Se ha eliminado correctamente a "+ personas.nombre;

    }


    public String  finalizarTarea(){
        informacion.finalizado = true;
        this.finalizacion = Fecha.fechaActual();
        return "La tarea " + informacion.titulo + " se ha marcado como finalizada";
    }

    public String toString(){
        return "Título :" + getTitulo() + "Personas : "+ getPersonas() + "\nResponsable :"+getResponsable() +"\n¿Finalizada?: " + getFinalizado() + "\nResultado: " + getResultado() + "\nFecha creación: "+ getCreacion() + "\nFecha finalización: " + getFinalizacion();
    }

    public static Tareas createTarea(String titulo,String descripcion,List<Personas> personas,Personas responsable, int prioridad, Fecha creacion, Fecha finalizacion,String resultado, List<String> etiquetas){
        return new Tareas(titulo.toLowerCase(),descripcion,personas,responsable,prioridad,resultado,etiquetas);
    }

    public String getTitulo(){
        return informacion.titulo;
    }

    public String getDescripcion() {
        return informacion.descripcion;
    }

    public String getResultado() {
        return informacion.resultado;
    }

    public boolean isFinalizado() {
        return informacion.finalizado;
    }

    public List<String> getEtiquetas() {
        return informacion.etiquetas;
    }

    public int getPrioridad() {
        return informacion.prioridad;
    }


    public List<Personas> getPersonas() {
        return participantes.personas;
    }

    public Personas getResponsable() {
        return participantes.responsable;
    }

    public Fecha getCreacion() {
        return creacion;
    }

    public Fecha getFinalizacion() {
        return finalizacion;
    }

    public String getFinalizado(){
        if (informacion.finalizado)
            return "Finalizado";
        else
            return "No finalizado";
    }
}
