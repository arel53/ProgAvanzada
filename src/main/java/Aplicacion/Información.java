package Aplicacion;

import java.util.List;

public class Información {

    String titulo;
    String descripcion;
    String resultado;
    boolean finalizado;
    List<String> etiquetas;
    int prioridad;


    public Información(String titulo, String descripcion, String resultado, List<String> etiquetas, int prioridad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.finalizado = false;
        this.resultado = resultado;
        this.etiquetas = etiquetas;
        this.prioridad = prioridad;
    }
}
