package Aplicacion.Excepcion;

import java.io.Serializable;

public class TareaNoExistente extends Exception  implements Serializable {
    public TareaNoExistente(){
        super();
    }
}
