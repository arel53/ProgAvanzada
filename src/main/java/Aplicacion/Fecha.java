package Aplicacion;

import java.time.LocalDate;
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
        return new Fecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    }



}
