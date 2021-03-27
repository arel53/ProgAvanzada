package Aplicacion;

import java.util.Calendar;

public class Fecha {
    int dia;
    int mes;
    int año;

    public Fecha(int dia,int mes,int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha(){}


    public String toString(){
        return dia + "/" + mes + "/" + año;
    }

    public static Fecha fechaActual(){
        return new Fecha(Calendar.DATE, Calendar.MONTH, Calendar.YEAR);
    }



}
