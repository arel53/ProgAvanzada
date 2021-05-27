package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;

import java.io.File;

public interface implementacionVista {

    void setModelo(Modelo modelo);
    void setControlador(Controlador controlador);
    void actualizar();
    void actualizarTabla();
    File ventanaAbrirFichero();
    void cerrarGuardarFichero(File f);
    void noExistePersona(String dni);
}
