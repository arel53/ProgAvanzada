package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelAltaTarea {


    private Controlador controlador;
    private JTextField titulo = new JTextField();
    private JTextField descripcion = new JTextField();
    private JTextField personas = new JTextField();
    private JTextField responsable = new JTextField();
    private JTextField prioridad = new JTextField();
    private JTextField idResultado = new JTextField();
    private JTextField nHoras = new JTextField();
    private JTextField tipo = new JTextField();
    private JTextField resultado = new JTextField();
    private JTextField etiquetas = new JTextField();
    private JTextField coste = new JTextField();
    private JTextField tipoFac = new JTextField();
    private JTextField fechaCreacion = new JTextField();

    private JButton insertar = new JButton("Añadir");
    private JFrame ventana;


    public PanelAltaTarea(Controlador controlador){
        this.controlador = controlador;

        ventana = new JFrame("Alta tarea");

        ventana.setLayout(new GridLayout(14,2));

        Container contenedor = ventana.getContentPane();

        contenedor.add(new JLabel("Titulo"));
        contenedor.add(titulo);
        contenedor.add(new JLabel("Descripción"));
        contenedor.add(descripcion);
        contenedor.add(new JLabel("Personas"));
        contenedor.add(personas);
        contenedor.add(new JLabel("Responsable"));
        contenedor.add(responsable);
        contenedor.add(new JLabel("Prioridad"));
        contenedor.add(prioridad);
        contenedor.add(new JLabel("idResultados"));
        contenedor.add(idResultado);
        contenedor.add(new JLabel("Número horas"));
        contenedor.add(nHoras);
        contenedor.add(new JLabel("Tipo"));
        contenedor.add(tipo);
        contenedor.add(new JLabel("Resultado esperado"));
        contenedor.add(resultado);
        contenedor.add(new JLabel("Etiquetas"));
        contenedor.add(etiquetas);
        contenedor.add(new JLabel("Coste"));
        contenedor.add(coste);
        contenedor.add(new JLabel("Tipo factura"));
        contenedor.add(tipoFac);
        contenedor.add(new JLabel("Fecha creación"));
        contenedor.add(fechaCreacion);
        contenedor.add(insertar);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);


        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertar();
            }
        });


    }


    public void vaciar() {
        nHoras.setText("");
        titulo.setText("");
        descripcion.setText("");
        personas.setText("");
        responsable.setText("");
        prioridad.setText("");
        idResultado.setText("");
        fechaCreacion.setText("");
        tipoFac.setText("");
        coste.setText("");
        etiquetas.setText("");
        resultado.setText("");
        tipo.setText("");
    }

    private void insertar(){
        vaciar();
    }
}
