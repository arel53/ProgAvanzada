package Aplicacion.Listas;

import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UtilidadesParaListas implements Serializable {


    public static <T extends tieneLista> List<T> elementosConListaVacia(List<T> objetos){

        List<T> objetosListasVacias = new LinkedList<T>();

        for (T objeto : objetos){

            if(objeto.getLista().isEmpty() ){
                objetosListasVacias.add(objeto);
            }
        }

        return objetosListasVacias;
    }


    public static <T extends tieneClave> boolean insertarEnLista(T clave, List<T> objetos){

        for (T objeto : objetos){
            
            if (objeto.getClave().equals(clave))
                return false;
        }
        return true;

    }

    //Hemos creado este método ya que al pasarle un parámetro de tipo String como clave no nos dejaba añadirlo.
    public static <T extends tieneClave> boolean insertarEnLista(String  clave, List<T> objetos){

        for (T objeto : objetos){

            if (objeto.getClave().equals(clave))
                return false;
        }
        return true;

    }

}
