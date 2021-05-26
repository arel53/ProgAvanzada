package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


public class PanelAltaTarea {


    private Controlador controlador;
    private JTextField titulo = new JTextField();
    private JTextField descripcion = new JTextField();
    private JButton personas = new JButton("Añadir personas");
    private JTextField responsable = new JTextField();
    private JTextField prioridad = new JTextField();
    private JTextField idResultado = new JTextField();
    private JTextField nHoras = new JTextField();
    private JTextField tipo = new JTextField();
    private JTextField resultado = new JTextField();
    private JButton etiquetas = new JButton("Añadir etiquetas");
    private JTextField etiquetasQueVasAAñadir = new JTextField();
    private JTextField coste = new JTextField();
    //private JTextField tipoFac = new JTextField();
    ButtonGroup grupo1 = new ButtonGroup();
    ButtonGroup grupo2 = new ButtonGroup();
    private JTextField fechaCreacion = new JTextField();

    private JButton insertar = new JButton("Añadir");
    private JFrame ventana;
    //private List<String> personasCap = new LinkedList<>();
    //private List<String> etiquetasCap = new LinkedList<>();
    private JTextField personasQueVasAAñadir = new JTextField();

    PanelAñadirPersonaTarea personasAñadir = null;
    AñadirEtiquetas etiquetasAñadir = null;


    public PanelAltaTarea(Controlador controlador){
        this.controlador = controlador;

        ventana = new JFrame("Alta tarea");

        ventana.setLayout(new GridLayout(25,4));

        Container contenedor = ventana.getContentPane();

        contenedor.add(new JLabel("Titulo: "));
        contenedor.add(titulo);
        contenedor.add(new JLabel("Descripción: "));
        contenedor.add(descripcion);
        contenedor.add(new JLabel("Personas : "));

        contenedor.add(personas);
        contenedor.add(new JLabel(""));
        contenedor.add(personasQueVasAAñadir);
        personasQueVasAAñadir.setEditable(false);
        contenedor.add(new JLabel("Responsable: "));
        contenedor.add(responsable);
        contenedor.add(new JLabel("Prioridad: "));
        contenedor.add(prioridad);
        contenedor.add(new JLabel("ID Resultado: "));
        contenedor.add(idResultado);
        contenedor.add(new JLabel("Número horas: "));
        contenedor.add(nHoras);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        JCheckBox biblioteca = new JCheckBox("Biblioteca");
        JCheckBox documentacion = new JCheckBox("Documentación");
        JCheckBox programa = new JCheckBox("Programa");
        JCheckBox pagWeb = new JCheckBox("Pag Web");
        grupo2.add(biblioteca);
        grupo2.add(documentacion);
        grupo2.add(programa);
        grupo2.add(pagWeb);
        biblioteca.setSelected(true);
        contenedor.add(biblioteca);
        contenedor.add(new JLabel("Tipo: "));
        contenedor.add(documentacion);
        contenedor.add(new JLabel(""));
        contenedor.add(programa);
        contenedor.add(new JLabel(""));
        contenedor.add(pagWeb);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        //contenedor.add(tipo);
        contenedor.add(new JLabel("Resultado esperado: "));
        contenedor.add(resultado);
        contenedor.add(new JLabel("Fecha creación: "));
        contenedor.add(fechaCreacion);
        contenedor.add(new JLabel("Coste: "));
        contenedor.add(coste);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        JCheckBox urgente = new JCheckBox("Urgente");
        JCheckBox consumoInterno = new JCheckBox("Consumo Interno");
        JCheckBox descuento = new JCheckBox("Descuento");
        grupo1.add(urgente);
        grupo1.add(consumoInterno);
        grupo1.add(descuento);
        consumoInterno.setSelected(true);
        contenedor.add(urgente);
        contenedor.add(new JLabel("Tipo factura: "));
        contenedor.add(consumoInterno);
        contenedor.add(new JLabel(""));
        contenedor.add(descuento);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel("Etiquetas: "));
        contenedor.add(etiquetas);
        contenedor.add(new JLabel(""));
        contenedor.add(etiquetasQueVasAAñadir);
        etiquetasQueVasAAñadir.setEditable(false);
        contenedor.add(new JLabel(""));
        contenedor.add(insertar);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);


        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarTarea();
            }
        });

        personas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personasAñadir == null)
                    personasAñadir = new PanelAñadirPersonaTarea(personasQueVasAAñadir);
                personasAñadir.abrirVentana();
            }
        });

        etiquetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personasAñadir == null)
                    etiquetasAñadir = new AñadirEtiquetas(etiquetasQueVasAAñadir);
                etiquetasAñadir.abrirVentana();
            }
        })
        ;




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
        //tipoFac.setText("");
        coste.setText("");
        etiquetas.setText("");
        resultado.setText("");
        tipo.setText("");
    }

    private void insertarTarea(){
        //controlador.insertarTarea();
        vaciar();
    }


}
