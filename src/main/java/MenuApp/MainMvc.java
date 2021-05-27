package MenuApp;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Vista.Vista;

import javax.swing.*;

public class MainMvc {
    public static void main(String[] args) {

        Vista vista = new Vista();
        Controlador controlador = new Controlador();
        Modelo modelo = new Modelo();
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setControlador(controlador);
        vista.setModelo(modelo);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.run();
            }
        });
    }

}
