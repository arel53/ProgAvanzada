package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Excepcion.PersonaNoExistente;
import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Persona.Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
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
    private JButton etiquetas = new JButton("Añadir etiquetas");
    private JTextField etiquetasQueVasAAñadir = new JTextField();
    private JTextField coste = new JTextField();
    //private JTextField tipoFac = new JTextField();
    ButtonGroup grupo1 = new ButtonGroup();
    ButtonGroup grupo2 = new ButtonGroup();
    ButtonGroup grupo3 = new ButtonGroup();

    private JButton insertar = new JButton("Añadir");
    private JFrame ventana;
    //private List<String> personasCap = new LinkedList<>();
    //private List<String> etiquetasCap = new LinkedList<>();
    private JTextField personasQueVasAAñadir = new JTextField();

    PanelAñadirPersonaTarea personasAñadir = null;
    AñadirEtiquetas etiquetasAñadir = null;

    private String tipoResultado;
    private String tipoFactura = "CONSUMOINTERNO";
    private String resultadoEsperado = "BIBLIOTECA";

    public PanelAltaTarea(Controlador controlador){
        this.controlador = controlador;

        ventana = new JFrame("Alta tarea");

        ventana.setLayout(new GridLayout(27,4));

        Container contenedor = ventana.getContentPane();

        contenedor.add(new JLabel("Titulo: "));
        contenedor.add(titulo);
        contenedor.add(new JLabel("Descripción: "));
        contenedor.add(descripcion);
        contenedor.add(new JLabel("Personas : "));

        contenedor.add(personas);
        contenedor.add(new JLabel("nº de personas"));
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

        //contenedor.add(tipo);
        JCheckBox interno = new JCheckBox("Interno");
        JCheckBox comercializado = new JCheckBox("Comercializado");
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel("Resultado esperado: "));
        contenedor.add(interno);
        contenedor.add(new JLabel(""));
        contenedor.add(comercializado);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel());
        interno.setActionCommand("INTERNO");
        comercializado.setActionCommand("COMERCIALIZADO");
        grupo3.add(interno);
        grupo3.add(comercializado);
        //contenedor.add(resultado);
        contenedor.add(new JLabel("Coste: "));
        contenedor.add(coste);
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        contenedor.add(new JLabel(""));
        JCheckBox urgente = new JCheckBox("Urgente");
        JCheckBox consumoInterno = new JCheckBox("Consumo Interno");
        JCheckBox descuento = new JCheckBox("Descuento");
        urgente.setActionCommand("URGENTE");
        consumoInterno.setActionCommand("CONSUMOINTERNO");
        descuento.setActionCommand("DESCUENTO");
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
        contenedor.add(new JLabel("nº de etiquetas"));
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
                else
                    personasAñadir.abrirVentana();
            }
        });

        etiquetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etiquetasAñadir == null)
                    etiquetasAñadir = new AñadirEtiquetas(etiquetasQueVasAAñadir);
                else
                    etiquetasAñadir.abrirVentana();
            }
        })
        ;


        final ItemListener itemListenerFac = itemEvent -> {
            JCheckBox boton = (JCheckBox) itemEvent.getItem();
            tipoFactura = boton.getActionCommand();
        };
        urgente.addItemListener(itemListenerFac);
        consumoInterno.addItemListener(itemListenerFac);
        descuento.addItemListener(itemListenerFac);

        final ItemListener itemListenerRes = itemEvent -> {
            JCheckBox boton = (JCheckBox) itemEvent.getItem();
            resultadoEsperado = boton.getActionCommand();
        };
        biblioteca.addItemListener(itemListenerRes);
        documentacion.addItemListener(itemListenerRes);
        programa.addItemListener(itemListenerRes);
        pagWeb.addItemListener(itemListenerRes);

        final ItemListener itemListenerResEsp = itemEvent -> {
            JCheckBox boton = (JCheckBox) itemEvent.getItem();
            tipoResultado = boton.getActionCommand();
        };
        interno.addItemListener(itemListenerResEsp);
        comercializado.addItemListener(itemListenerResEsp);

    }







    public void vaciar() {
        nHoras.setText("");
        titulo.setText("");
        descripcion.setText("");
        responsable.setText("");
        prioridad.setText("");
        idResultado.setText("");
        fechaCreacion.setText("");
        //tipoFac.setText("");
        coste.setText("");
        tipo.setText("");
    }

    private void insertarTarea(){
        List<String> etiquetas = new LinkedList<>();
        List<String> personas = new LinkedList<>();
        try {
            if (personasAñadir != null)
                personas = personasAñadir.getPersonas();
            if (etiquetasAñadir != null)
                etiquetas = etiquetasAñadir.getEtiquetas();
            controlador.altaTarea(titulo.getText(),descripcion.getText(),personas,responsable.getText(),prioridad.getText(),idResultado.getText(),nHoras.getText(),tipoResultado,resultadoEsperado,etiquetas,coste.getText(),tipoFactura);
            vaciar();
        }
        catch (TareaExistente | PersonaNoAñadida | PersonaNoExistente e){
            new VentanaEmergente(ventana,e.getMessage(),true);
        }
        catch (Exception e1) {
            new VentanaEmergente(ventana, "Debes rellenar los campos correctamente", true);
        }

        //titulo,descrip,personas,responable,prioridad,idresul,nhoras,,interno/comer,creac,tipofac,coste,fac,etiquetas
    }


}
