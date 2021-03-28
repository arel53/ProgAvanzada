package Aplicacion.Resultado;


public class Biblioteca extends Programa {

    public Biblioteca(String id, double horas, String tipo, String lenguaje, int lineas, int modulos){
        this.id = id;
        this.horas = horas;
        this.tipo = tipo;
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Biblioteca(String lenguaje, int lineas, int modulos){
        this.lenguaje = lenguaje;
        this.lineas = lineas;
        this.modulos = modulos;
    }
    public Biblioteca(){

    }
}
