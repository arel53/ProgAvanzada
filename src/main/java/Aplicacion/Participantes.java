package Aplicacion;

import java.util.List;

public class Participantes extends Tareas{

    List<Personas> personas;
    Personas responsable;

    public Participantes(List<Personas> personas, Personas responsable){

        this.personas = personas;
        this.responsable = responsable;
    }


}