package MenuApp;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Vista.Vista;

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
        modelo.setProyecto(Proyecto.iniciarProyecto("1.bin"));
        vista.run();
    }
}
