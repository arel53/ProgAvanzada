package Aplicacion.Tareas;

import Aplicacion.Fecha.Fecha;
import Aplicacion.Persona.Personas;
import Aplicacion.Resultado.Resultado;

import java.util.Set;

public class Tareas {
    Informacion informacion;
    Fecha creacion;
    Fecha finalizacion;
    Participantes participantes;

    public Tareas(String titulo, String descripcion, Set<Personas> personas, Personas responsable, int prioridad, Resultado resultado, Set<String> etiquetas){

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
        return "Título :" + getTitulo() + "\nPersonas : "+ getPersonas() + "\nResponsable :"+getResponsable() +"\n¿Finalizada?: " + getFinalizado() + "\nResultado: " + getResultado() + "\nFecha creación: "+ getCreacion() + "\nFecha finalización: " + getFechaFinalizacion()+ "\n\n";
    }

    public static Tareas createTarea(String titulo,String descripcion,Set<Personas> personas,Personas responsable, int prioridad,Resultado resultado, Set<String> etiquetas){
        return new Tareas(titulo.toLowerCase(),descripcion,personas,responsable,prioridad,resultado,etiquetas);
    }

    public String getTitulo(){
        return informacion.titulo;
    }

    public String getDescripcion() {
        return informacion.descripcion;
    }

    public Resultado getResultado() {
        return informacion.resultado;
    }

    public boolean isFinalizado() {
        return informacion.finalizado;
    }

    public Set<String> getEtiquetas() {
        return informacion.etiquetas;
    }

    public int getPrioridad() {
        return informacion.prioridad;
    }


    public Set<Personas> getPersonas() {
        return participantes.personas;
    }

    public Personas getResponsable() {
        return participantes.responsable;
    }

    public Fecha getCreacion() {
        return creacion;
    }

    public Fecha getFechaFinalizacion() {
        return finalizacion;
    }

    // TODO: Es mejor que devuelva el booleano que una cadena
    public boolean getFinalizado(){
        return informacion.finalizado;
    }
}
