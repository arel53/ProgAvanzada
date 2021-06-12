package Aplicacion.Controlador;

import Aplicacion.Excepcion.*;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Vista.ImplementacionVista;

import java.util.List;

public interface Controlador {
    void setModelo(ImplementacionModelo modelo);
    void setVista(ImplementacionVista vista);
    void insertarPersona() throws PersonaNoAñadida;
    void insertarPersonaTarea() throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente;
    void eliminarPersonaTarea() throws PersonaNoEliminada, TareaNoExistente, PersonaNoExistente;
    void finalizarTarea() throws TareaNoExistente;
    void cambiarCosteTarea() throws TareaNoExistente;
    void altaTarea() throws TareaExistente, PersonaNoAñadida, PersonaNoExistente;

    }
