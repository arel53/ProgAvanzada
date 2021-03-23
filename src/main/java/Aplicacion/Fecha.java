package Aplicacion;

public class Fecha {
    int dia;
    int mes;
    int año;

    public Fecha(int dia,int mes,int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }


    public String toString(){
        return dia + "/" + mes + "/" + año;
    }

}
