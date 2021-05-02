package Aplicacion.Tareas;

import Aplicacion.Fecha.Fecha;
import Aplicacion.Listas.tieneLista;
import Aplicacion.Persona.Personas;
import Aplicacion.Resultado.Resultado;
import java.io.Serializable;
import java.util.List;
import Aplicacion.Listas.tieneClave;

public class Tareas implements tieneLista<Personas>,tieneClave<String>,Serializable {
    private static final long serialVersionUID=42L;
    Informacion informacion;
    Fecha creacion;
    Fecha finalizacion;
    Participantes participantes;
    calcularFacturacion calculofacturacion;
    double coste;
    double facturacion;

    public Tareas(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas){

        this.informacion = new Informacion(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
        creacion = Fecha.fechaActual();
        finalizacion = new Fecha();

    }

    public Tareas(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas, calcularFacturacion calculofacturacion, double coste, double facturacion){

        this.informacion = new Informacion(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
        creacion = Fecha.fechaActual();
        finalizacion = new Fecha();
        this.calculofacturacion = calculofacturacion;
        this.coste = coste;
        this.facturacion = facturacion;

    }

    public Tareas(){
        informacion = new Informacion();
        participantes = new Participantes();
        creacion = new Fecha();
        finalizacion = new Fecha();
    }


    public boolean introducirPersonaTarea(Personas persona){
        return participantes.personas.add(persona);
    }


    public boolean eliminarPersonaTarea(Personas personas){
        return participantes.personas.remove(personas);
    }


    public String  finalizarTarea(){
        informacion.finalizado = true;
        this.finalizacion = Fecha.fechaActual();
        return "La tarea " + informacion.titulo + " se ha marcado como finalizada";
    }

    public String toString(){
        return "Título: " + getClave() + "\nPersonas: "+ getLista() + "\nResponsable: "+getResponsable() +"\n¿Finalizada?: " + getFinalizado() + "\n Id del resultado: " + getResultado().getIdResultado() + "\nFecha creación: "+ getCreacion() +
                "\nFecha finalización: " + getFechaFinalizacion()+ "\nCoste: "+ getCoste() + "€\nFacturación: "+ getFacturacion() +"€\n\n";
    }

    public static Tareas createTarea(String titulo, String descripcion, List<Personas> personas, Personas responsable, int prioridad, Resultado resultado, List<String> etiquetas, calcularFacturacion calculofacturacion, double coste,double facturacion){
        return new Tareas(titulo.toLowerCase(),descripcion,personas,responsable,prioridad,resultado,etiquetas,calculofacturacion,coste,facturacion);
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

    public List<String> getEtiquetas() {
        return informacion.etiquetas;
    }

    public int getPrioridad() {
        return informacion.prioridad;
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

    public boolean getFinalizado(){
        return informacion.finalizado;
    }

    @Override
    public List<Personas> getLista() {
        return  participantes.personas;
    }

    @Override
    public String getClave() {
        return informacion.titulo;
    }


    public double getCoste(){
        return coste;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setCoste(double coste){
        this.coste = coste;
    }

    public void setFacturacion(double facturacion){
        this.facturacion = facturacion;
    }

    public calcularFacturacion getCalcularFacturacion(){
        return calculofacturacion;
    }
}
