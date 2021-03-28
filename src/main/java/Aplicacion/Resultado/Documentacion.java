package Aplicacion.Resultado;

import Aplicacion.Resultado.Resultado;

public class Documentacion extends Resultado {
    String format;
    int pags;
    float espacio;

    public Documentacion(String id, double horas, String tipo, String format, int pags, float espacio){
        super(id,horas,tipo);
        this.format = format;
        this.pags = pags;
        this.espacio = espacio;
    }
    public Documentacion(String format, int pags, float espacio){
        this.format = format;
        this.pags = pags;
        this.espacio = espacio;
    }

    public Documentacion(){

    }


}
