package Aplicacion.Excepcion;

import Aplicacion.Persona.Personas;

import javax.swing.*;

public class PersonaNoEliminada extends Exception{
    public PersonaNoEliminada(){
        super("La persona no ha sido eliminada");
    }
    public PersonaNoEliminada(String s){
        super(s);
    }
}
