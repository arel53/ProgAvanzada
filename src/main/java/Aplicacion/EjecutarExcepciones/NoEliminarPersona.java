package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.PersonaNoEliminada;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Listas.tieneClave;
import Aplicacion.Persona.Personas;

import java.util.List;

public class NoEliminarPersona {
    public static<T extends tieneClave<E>, E > void ejecutaNoEliminarPersona(E clave, List<T> lista) throws PersonaNoExistente {

        //No existe la persona si devuelve true
        if(UtilidadesParaListas.insertarEnLista(clave,lista)){
                throw new PersonaNoExistente("La persona no se ha eliminado ya que no existe");
        }
    }

    public static void ejecutaNoEliminarPersonaResponsable(Personas p1, Personas pR) throws PersonaNoEliminada {
        if (pR.equals(p1)){
            throw new PersonaNoEliminada("La persona no se ha eliminado ya que es la responsable de la tarea");
        }
    }
}
