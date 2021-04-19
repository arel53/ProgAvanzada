package Aplicacion.Excepcion;

import java.io.Serializable;

public class TareaExistente extends Exception implements Serializable {
    public TareaExistente(){
        super("La tarea ya está introducida en el proyecto.");
    }
}
