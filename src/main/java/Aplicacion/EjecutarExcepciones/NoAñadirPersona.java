package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Listas.tieneClave;
import Aplicacion.Persona.Personas;
import jdk.jshell.execution.Util;

import java.util.List;

public class NoAñadirPersona {
    // CORREGIDO: es sorprendente que tengáis una clase para "no añadir una persona". Está claro que lo que
    //   hace es añadirla, pero el nombre indica lo contrario. Y los nombres son importantes. Hacer que
    //   un método se llame lo contrario de lo que hace es una muy mala práctica.

    public static <T extends tieneClave<E>, E>void ejecutaAñadirPersonaExcepcion(E dni, List<T> personas, String s) throws PersonaNoAñadida {
            if (!UtilidadesParaListas.insertarEnLista(dni,personas))
                throw new PersonaNoAñadida(s);

    }
    public static <T extends tieneClave<E>, E>void ejecutaAñadirPersonaExcepcion(E dni, List<T> personas) throws PersonaNoAñadida {
        if (!UtilidadesParaListas.insertarEnLista(dni,personas))
            throw new PersonaNoAñadida("La persona no ha sido añadida");

    }
}
