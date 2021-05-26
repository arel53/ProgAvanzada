package Aplicacion.Controlador;

import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoEliminada;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaNoExistente;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Vista.Vista;

public interface implementacionControlador {
    public void setModelo(Modelo modelo);
    public void setVista(Vista vista);
    public void insertarPersona(String nombre, String DNI, String correo) throws PersonaNoAñadida;
    public void insertarPersonaTarea(String id, String DNI) throws PersonaNoAñadida, TareaNoExistente, PersonaNoExistente;
    public void eliminarPersonaTarea(String id, String DNI) throws PersonaNoEliminada, TareaNoExistente, PersonaNoExistente;
    public void finalizarTarea(String id) throws TareaNoExistente;
   public void cambiarCosteTarea(String id, String coste) throws TareaNoExistente;
}
