package Aplicacion.Resultado;

public class Resultado {

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