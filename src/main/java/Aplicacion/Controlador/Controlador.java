package Aplicacion.Controlador;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Persona.Personas;
import Aplicacion.Vista.Vista;

import java.util.List;
import java.util.Locale;

public class Controlador {
    private Modelo modelo;
    private Vista vista;








    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void setVista(Vista vista){
        this.vista = vista;
    }

    public void insertarPersona(String nombre, String DNI, String correo) throws PersonaNoAñadida {
        Personas persona = null;
        persona = Personas.createPersona(DNI.toUpperCase(Locale.ROOT),nombre,correo,modelo.getProyecto().listarPersonas());
        modelo.insertarPersona(persona);
    }


}
