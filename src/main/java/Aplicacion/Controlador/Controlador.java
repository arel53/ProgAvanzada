package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Modelo.Tabla;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Vista.Vista;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Controlador implements implementacionControlador{
    private Modelo modelo;
    private Vista vista;


    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void setVista(Vista vista){
        this.vista = vista;
    }

    public void insertarPersona(String nombre, String DNI, String correo) throws PersonaNoAñadida {
        Personas persona;
        persona = Personas.createPersona(DNI.toUpperCase(Locale.ROOT),nombre,correo,modelo.getProyecto().listarPersonas());
        modelo.insertarPersona(persona);
    }

    public void insertarPersonaTarea(String id, String Dni) throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente {
        modelo.insertarPersonaTarea(id,Dni);
    }

    public void eliminarPersonaTarea(String id, String DNI) throws PersonaNoEliminada, TareaNoExistente, PersonaNoExistente {
        modelo.eliminarPersonaTarea(id,DNI);
    }


    public void finalizarTarea(String id) throws TareaNoExistente{
        modelo.finalizarTarea(id);
    }

    public void cambiarCosteTarea(String id, String coste) throws TareaNoExistente {
        modelo.cambiarCosteTarea(id,coste);

    }

    public void altaTarea( String titulo, String descripcion, List<String> personas, String responsable, String prioridad, String idResultado,String nHoras, String tipoResultado ,String resultadoEsperado ,List<String> etiquetas,String coste, String tipoFactura ) throws TareaExistente, PersonaNoAñadida, PersonaNoExistente {

        modelo.altaTarea(titulo,descripcion,personas,responsable,prioridad,idResultado,nHoras,tipoResultado,resultadoEsperado,etiquetas,coste,tipoFactura);

        //titulo,descrip,personas,responable,idresul,prioridad,creac,tipofac,coste,fac,etiquetas
    }



}
