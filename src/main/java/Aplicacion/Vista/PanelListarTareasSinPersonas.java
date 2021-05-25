package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;

import javax.swing.*;

public class PanelListarTareasSinPersonas {

    JFrame ventana = new JFrame("Listar tareas sin personas");
    JTextArea areaDatosLista = new JTextArea(20,10);
    Controlador controlador;

    public PanelListarTareasSinPersonas(Controlador controlador){

        this.controlador = controlador;

        JScrollPane panel = new JScrollPane(areaDatosLista);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        ventana.getContentPane().add(panel);

        ventana.setBounds(100, 100, 450, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        areaDatosLista.setEditable(false);


    }

}
