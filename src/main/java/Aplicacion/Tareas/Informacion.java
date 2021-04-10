package Aplicacion.Tareas;

import java.util.Set;

public class Informacion {

    String titulo;
    String descripcion;
    // TODO: el resultado tiene que ser de la clase Resultado, no una cadena
    String resultado;
    boolean finalizado;
    Set<String> etiquetas;
    int prioridad;


    public Informacion(String titulo, String descripcion, String resultado, Set<String> etiquetas, int prioridad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.finalizado = false;
        this.resultado = resultado;
        this.etiquetas = etiquetas;
        this.prioridad = prioridad;
    }

    public Informacion() {

    }
}
