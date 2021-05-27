package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Proyecto.Proyecto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vista extends WindowAdapter implements implementacionVista {

    private Controlador controlador;
    private Modelo modelo;
    private JFrame ventana = new JFrame("Proyecto");
    private PanelPersonas vistaPersonas;
    private PanelTareas vistaTareas;
    File f;
    private JButton cambiarProyecto;



    public void run(){

        this.f = ventanaAbrirFichero();

        JTabbedPane pestañas = new JTabbedPane();
        vistaPersonas = new PanelPersonas(modelo,ventana,controlador);
        vistaTareas = new PanelTareas(modelo,ventana,controlador);
        cambiarProyecto = new JButton("Cambiar de proyecto");


        pestañas.add("Personas",vistaPersonas);
        pestañas.add("Tareas",vistaTareas);

        ventana.add(pestañas);
        actualizar();
        vistaPersonas.addComponente(cambiarProyecto);



        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarGuardarFichero(f);
                System.exit(0);
            }
        });

        cambiarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarGuardarFichero(f);
                ventana.dispose();
                abrirNuevoProyecto();
            }
        });


        ventana.pack();
        ventana.setLocationRelativeTo(null);

    }

    @Override
    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    @Override
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }


    public void actualizar(){

        vistaPersonas.actualizar();
        vistaTareas.actualizar();
    }
    public void actualizarTablas(){
        vistaPersonas.actualizarTabla();
    }

    public File ventanaAbrirFichero(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichero binario","bin"));
        int resultado = fileChooser.showDialog(ventana,"Elige un fichero");
        File f = null;
        switch (resultado){
            case JFileChooser.CANCEL_OPTION:
                System.exit(0);
                break;
            case JFileChooser.APPROVE_OPTION:
                f = fileChooser.getSelectedFile();
                try{
                    modelo.abrirFichero(f);
                }
                catch (FileNotFoundException e1){
                    new VentanaEmergente(ventana,"Se va a crear un nuevo fichero ya que el introducido no existe", true);
                    modelo.setProyecto(Proyecto.iniciarProyecto(f.toString()));
                }catch (Exception e2){
                    new VentanaEmergente(ventana,e2.getMessage(),true);
                }
                break;
            case JFileChooser.ERROR_OPTION:
                new VentanaEmergente(ventana,"Error",true);
                System.exit(0);
                break;
        }
        return f;
    }

    public void cerrarGuardarFichero(File f){
        try {
            modelo.guardarFichero(f);
        }
        catch (IOException e){
            new VentanaEmergente(ventana,e.getMessage(),true);
        }
    }

    public static void abrirNuevoProyecto(){
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador();
        vista.setControlador(controlador);
        vista.setModelo(modelo);
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.run();
            }
        });
    }

    public void noExistePersona(String dni){
        new VentanaEmergente(ventana,"La persona "+ dni+ "no existe", true);
    }

}
