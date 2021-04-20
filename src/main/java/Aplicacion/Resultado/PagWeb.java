package Aplicacion.Resultado;

import Aplicacion.Resultado.Resultado;

import java.io.Serializable;

public class PagWeb extends Resultado implements Serializable  {
    String clase;
    String lenguaje;
    String backEnd;

    public PagWeb(String id, double horas, String tipo, String clase, String lenguaje, String backEnd){
        super(id,horas,tipo);
        this.clase = clase;
        this.lenguaje = lenguaje;
        this.backEnd = backEnd;
    }

    public PagWeb() {

    }
}
