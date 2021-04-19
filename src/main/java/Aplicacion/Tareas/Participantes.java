package Aplicacion.Tareas;

import Aplicacion.Persona.Personas;

import java.util.Set;

public class Participantes implements Serializable {

    Set<Personas> personas;
    Personas responsable;

    public Participantes(Set<Personas> personas, Personas responsable){

        this.personas = personas;
        this.responsable = responsable;
    }

    public Participantes() {
    }
}
