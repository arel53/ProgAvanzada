package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;

import javax.swing.*;

public class PanelListarTareasSinPersonas {

    JFrame ventana = new JFrame("Listar tareas sin personas");
    JTextArea areaDatosLista = new JTextArea(20,10);
    Controlador controlador;
    Modelo modelo;

    public PanelListarTareasSinPersonas(Controlador controlador, Modelo modelo){

        this.controlador = controlador;
        this.modelo = modelo;

        JScrollPane panel = new JScrollPane(areaDatosLista);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        actualizar();

        ventana.getContentPane().add(panel);

        ventana.setBounds(100, 100, 450, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        areaDatosLista.setEditable(false);


    }

    public void actualizar(){
        StringBuilder datos = modelo.textoTareas(modelo.listarTareasSinPersonas());
        areaDatosLista.setText("");
        areaDatosLista.append(String.valueOf(datos));

    }
}
