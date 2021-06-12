package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Persona.Personas;
import Aplicacion.Vista.ImplementacionVista;
import Aplicacion.Vista.Vista;

import java.util.List;

public class ImplementacionControlador implements Controlador {
    // CORREGIDO Tanto el model como la vista deben ser interfaces, no clases concretas
    private Modelo modelo;
    private Vista vista;

    // CORREGIDO: Tenéis los nombres al revés: lo natural es que ImplementaciónXXXX sea la implementación,
    //       no la interfaz
// TODO: El controlador debería tener un método por cada posible acción del usuario, aquí faltan
//       muchos




    public void setModelo(ImplementacionModelo modelo){
        this.modelo = modelo;
    }

    public void setVista(ImplementacionVista vista){
        this.vista = vista;
    }

    // CORREGIDO: El controlador debe pedir a la vista los datos que necesita, no recibirlos como parámetros. Por eso
    //    os marca la vista como no utilizada. Este comentario sirve para el resto de métodos.

    public void insertarPersona() throws PersonaNoAñadida {
        Personas persona;
        persona = Personas.createPersona(vista.getDniPanelPersonas().toUpperCase(), vista.getNombrePanelPersonas(), vista.getCorreoPanelPersonas(), modelo.getProyecto().listarPersonas());
        modelo.insertarPersona(persona);
    }

    public void insertarPersonaTarea() throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente {
        modelo.insertarPersonaTarea(vista.getTituloPanelTareas(), vista.getDniPanelTareas());
    }

    public void eliminarPersonaTarea() throws PersonaNoEliminada, TareaNoExistente, PersonaNoExistente {
        modelo.eliminarPersonaTarea(vista.getTituloPanelTareas(), vista.getDniPanelTareas());
    }


    public void finalizarTarea() throws TareaNoExistente{
        modelo.finalizarTarea(vista.getTituloPanelTareas());
    }

    public void cambiarCosteTarea() throws TareaNoExistente {
        modelo.cambiarCosteTarea(vista.getTituloPanelTareas(), vista.getCostePanelTareas());

    }

    public void altaTarea() throws TareaExistente, PersonaNoAñadida, PersonaNoExistente {

        modelo.altaTarea(vista.getTituloAltaTarea(), vista.getDescripcionAltaTarea(), vista.getPersonasAltaTarea(), vista.getResponsableAltaTarea(), vista.getPrioridadAltaTarea(), vista.getIdResultadoAltaTarea(), vista.getNhorasAltaTarea(), vista.getTipoResultadoAltaTarea(), vista.getResultadoEsperadoAltaTarea(), vista.getEtiquetasAltaTarea(), vista.getCosteAltaTarea(), vista.getTipoFacturaAltaTarea());
        //titulo,descrip,personas,responable,idresul,prioridad,creac,tipofac,coste,fac,etiquetas
    }





}
