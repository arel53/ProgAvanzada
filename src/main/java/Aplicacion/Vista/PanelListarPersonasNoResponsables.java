package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Persona.Personas;

import javax.swing.*;
import java.util.List;

public class PanelListarPersonasNoResponsables {
    JFrame ventana=new JFrame("Listar personas no responsables");JTextArea areaDatos=new JTextArea();
    Controlador controlador;
    Modelo modelo;
    public PanelListarPersonasNoResponsables(Controlador controlador, Modelo modelo){
        this.controlador=controlador;
        this.modelo=modelo;
        JScrollPane panel= new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        actualizar();
        ventana.getContentPane().add(panel);

        ventana.setBounds(100, 100, 450, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        areaDatos.setEditable(false);

    }


    public void actualizar(){
        StringBuilder datos = modelo.textoPersonas(modelo.listarPersonasNoResponsables());
        areaDatos.setText("");
        areaDatos.append(String.valueOf(datos));

    }
}
