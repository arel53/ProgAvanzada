package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Listas.tieneClave;
import Aplicacion.Persona.Personas;
import jdk.jshell.execution.Util;

import java.util.List;

public class NoAñadirPersona {

    public static <T extends tieneClave<E>, E>void ejecutaNoAñadirPersona(E dni, List<T> personas) throws PersonaNoAñadida {
            if (!UtilidadesParaListas.insertarEnLista(dni,personas))
                throw new PersonaNoAñadida("La persona no ha sido añadida");

    }
}
