package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Excepcion.PersonaNoAñadida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaPersona {
    private Controlador controlador;
    private JTextField dni = new JTextField(10);
    private JTextField nombre = new JTextField(20);
    private JTextField correo = new JTextField(20);
    private JButton insertar = new JButton("Insertar");
    private JFrame ventana= new JFrame("Insertar cliente");

    public PanelAltaPersona(Controlador controlador){
        this.controlador=controlador;
        ventana.setLayout(new GridLayout(4,2));
        Container contenedor=ventana.getContentPane();

        contenedor.add(new JLabel("DNI"));
        contenedor.add(dni);
        contenedor.add(new JLabel("Nombre"));
        contenedor.add(nombre);
        contenedor.add(new JLabel("Correo"));
        contenedor.add(correo);
        contenedor.add(insertar);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);







        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarPersona();
                vaciar();
            }
        });

    }
    public void vaciar() {
        nombre.setText("");
        dni.setText("");
        correo.setText("");
    }

    private void insertarPersona(){

        try {
            controlador.insertarPersona(nombre.getText(),dni.getText(),correo.getText());
        }
        catch (PersonaNoAñadida e){
            new VentanaEmergente(ventana,e.getMessage(),true);
        }
    }
}
