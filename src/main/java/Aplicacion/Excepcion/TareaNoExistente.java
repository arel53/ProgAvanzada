package Aplicacion.Excepcion;

import java.io.Serializable;

public class TareaNoExistente extends Exception{
    public TareaNoExistente(){
        super();
    }
    public TareaNoExistente(String s){super(s);}
}
