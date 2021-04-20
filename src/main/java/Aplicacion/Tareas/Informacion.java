package Aplicacion.Tareas;

import Aplicacion.Resultado.Resultado;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Informacion implements Serializable {

    String titulo;
    String descripcion;
    // TODO: el resultado tiene que ser de la clase Resultado, no una cadena
    Resultado resultado;
    boolean finalizado;
    List<String> etiquetas;
    int prioridad;


    public Informacion(String titulo, String descripcion, Resultado resultado, List<String> etiquetas, int prioridad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.finalizado = false;
        this.resultado = resultado;
        this.etiquetas = new LinkedList<>(etiquetas);
        this.prioridad = prioridad;
    }

    public Informacion() {

    }
}
