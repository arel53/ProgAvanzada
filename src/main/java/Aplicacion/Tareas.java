package Aplicacion;

import java.util.List;

public class Tareas {
    Información información;
    Fecha creacion;
    Fecha finalizacion;
    Participantes participantes;

    public Tareas(String titulo,String descripcion,List<Personas> personas,Personas responsable, int prioridad,String resultado, List<String> etiquetas){

        this.información = new Información(titulo, descripcion,resultado,etiquetas,prioridad);
        this.participantes = new Participantes(personas,responsable);
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
        información.finalizado = true;
        return "La tarea" + información.titulo + "se ha marcado como finalizada";
    }

    public String toStringLista(){
        return "Título :" + información.titulo + "Personas : "+ participantes.personas + "¿Finalizada? :" + información.finalizado + "Resultado: " + información.resultado;
    }

    public static Tareas createTarea(String titulo,String descripcion,List<Personas> personas,Personas responsable, int prioridad, Fecha creacion, Fecha finalizacion,String resultado, List<String> etiquetas){
        return new Tareas(titulo,descripcion,personas,responsable,prioridad,resultado,etiquetas);
    }
}
