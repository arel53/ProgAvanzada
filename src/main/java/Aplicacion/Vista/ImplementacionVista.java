package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Controlador.ImplementacionControlador;
import Aplicacion.Modelo.ImplementacionModelo;
import Aplicacion.Modelo.Modelo;
import Aplicacion.Proyecto.Proyecto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ImplementacionVista extends WindowAdapter implements Vista {

    // CORREGIDO tanto el controlador como el modelo deben ser interfaces, no clases concretas

    private Controlador controladora;
    private Modelo modelo;
    private JFrame ventana = new JFrame("Proyecto");
    private PanelPersonas vistaPersonas;
    private PanelTareas vistaTareas;
    File f;
    private JButton cambiarProyecto;



    public void run(){

        this.f = ventanaAbrirFichero();

        JTabbedPane pestañas = new JTabbedPane();
        vistaPersonas = new PanelPersonas(modelo,ventana, controladora);
        vistaTareas = new PanelTareas(modelo,ventana, controladora);
        cambiarProyecto = new JButton("Cambiar de proyecto");


        pestañas.add("Personas",vistaPersonas);
        pestañas.add("Tareas",vistaTareas);

        ventana.add(pestañas);
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

    public void setModelo(ImplementacionModelo modelo){
        this.modelo = modelo;
    }

    public void setControlador(ImplementacionControlador controladora){
        this.controladora = controladora;
    }


    public void actualizar(){

        vistaPersonas.actualizarTabla();
        vistaTareas.actualizarTabla();
    }
    public void actualizarTabla(){
        vistaPersonas.actualizarTabla();
        vistaTareas.actualizarTabla();
    }

    public File ventanaAbrirFichero(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichero binario","bin"));
        fileChooser.setDialogTitle("Elige un fichero (Para crear nuevo fichero introducir el nombre del proyecto + .bin)");
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
        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplementacionControlador controladora = new ImplementacionControlador();
        vista.setControlador(controladora);
        vista.setModelo(modelo);
        modelo.setVista(vista);
        controladora.setVista(vista);
        controladora.setModelo(modelo);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.run();
            }
        });
    }

    public void noExistePersona(String dni){
        new VentanaEmergente(ventana,"La persona '"+ dni + "' no existe y por lo tanto no se va a añadir a esta persona en la tarea", true);
    }


    public String getDniPanelPersonas(){
        return vistaPersonas.getDni();
    }

    public String getNombrePanelPersonas(){
        return vistaPersonas.getNombre();
    }

    public String getCorreoPanelPersonas(){
        return vistaPersonas.getCorreo();
    }

    public String getTituloAltaTarea(){
        return vistaTareas.getTituloAltaTarea();
    }

    public String getDescripcionAltaTarea(){
        return vistaTareas.getDescripcionAltaTarea();
    }

    public String getResponsableAltaTarea(){
        return vistaTareas.getResponsableAltaTarea();
    }

    public String getPrioridadAltaTarea(){
        return vistaTareas.getPrioridadAltaTarea();
    }

    public String getIdResultadoAltaTarea(){
        return vistaTareas.getIdResultadoAltaTarea();
    }

    public String getTipoResultadoAltaTarea(){
        return vistaTareas.getTipoResultadoAltaTarea();
    }

    public String getNhorasAltaTarea(){
        return vistaTareas.getNhorasAltaTarea();
    }

    public String getResultadoEsperadoAltaTarea(){
        return vistaTareas.getResultadoEsperadoAltaTarea();
    }

    public String getTipoFacturaAltaTarea(){
        return vistaTareas.getTipoFacturaAltaTarea();
    }

    public String getCosteAltaTarea(){
        return vistaTareas.getCosteAltaTarea();
    }

    public List<String> getEtiquetasAltaTarea(){
        return vistaTareas.getEtiquetasAltaTarea();
    }



    public List<String> getPersonasAltaTarea(){
        return vistaTareas.getPersonasAltaTarea();
    }
    @Override
    public String getDniPanelTareas() {
        return vistaTareas.getPersona();
    }

    @Override
    public String getTituloPanelTareas() {
        return vistaTareas.getTitulo();
    }

    @Override
    public String getCostePanelTareas() {
        return vistaTareas.getCoste();
    }




}
