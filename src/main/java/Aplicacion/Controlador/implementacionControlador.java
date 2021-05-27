package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Vista.Vista;

import java.util.List;

public interface implementacionControlador {
    void setModelo(Modelo modelo);
    void setVista(Vista vista);
    void insertarPersona(String nombre, String DNI, String correo) throws PersonaNoAñadida;
    void insertarPersonaTarea(String id, String DNI) throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente;
    void eliminarPersonaTarea(String id, String DNI) throws PersonaNoEliminada, TareaNoExistente, PersonaNoExistente;
    void finalizarTarea(String id) throws TareaNoExistente;
    void cambiarCosteTarea(String id, String coste) throws TareaNoExistente;
    void altaTarea(String titulo, String descripcion, List<String> personas, String responsable, String prioridad, String idResultado, String nHoras, String tipoResultado, String resultadoEsperado, List<String> etiquetas, String coste, String tipoFactura) throws TareaExistente, PersonaNoAñadida, PersonaNoExistente;

    }
