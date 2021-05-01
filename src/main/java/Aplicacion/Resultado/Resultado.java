package Aplicacion.Resultado;

import java.io.Serializable;

public abstract class Resultado implements Serializable {

    String id;
    double horas;
    String tipo;

    public Resultado(String id, double horas, String tipo){
        this.id = id;
        this.horas = horas;
        this.tipo = tipo;
    }

    public Resultado(){

    }

    public String toString(){

        return "ID :" + id;

    }

}
