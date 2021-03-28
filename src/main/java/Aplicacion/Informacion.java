package Aplicacion;

import java.util.List;

public class Informacion {

    String titulo;
    String descripcion;
    String resultado;
    boolean finalizado;
    List<String> etiquetas;
    int prioridad;


    public Informacion(String titulo, String descripcion, String resultado, List<String> etiquetas, int prioridad){
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
