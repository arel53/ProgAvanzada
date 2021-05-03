package Aplicacion.EjecutarMétodos;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Persona.Personas;

import java.util.List;

public class NoAñadirPersona {

    public static void ejecutaNoAñadirPersona(List<Personas> personas,Personas persona) throws PersonaNoAñadida {
            if (personas.contains(persona))
                throw new PersonaNoAñadida("La persona ya estaba añadida");

    }
}
