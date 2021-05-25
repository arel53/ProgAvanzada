package Aplicacion.Vista;

import Aplicacion.Controlador.Controlador;
import Aplicacion.Modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTareas extends JPanel{

    Modelo modelo;
    JFrame vista;
    Controlador controlador;
    JTextField textoDni;
    JTextField textoIdTarea;
    JTextField textoCoste;
    private JTextArea zonaTextoTareas = new JTextArea(25, 10);




    public PanelTareas(Modelo modelo, JFrame vista, Controlador controlador){

        this.modelo = modelo;
        this.vista = vista;
        this.controlador = controlador;

        JLabel idTarea = new JLabel("Id tarea: ");
        textoIdTarea = new JTextField(5);
        JLabel dniPersona = new JLabel("DNI :");
        textoDni = new JTextField(10);
        JLabel coste = new JLabel("Coste: ");
        textoCoste = new JTextField(5);



        JButton altaTarea = new JButton("Alta tarea");
        JButton finalizarTarea = new JButton("Finalizar tarea");
        JButton introducirPersona = new JButton("Introducir persona");
        JButton eliminarPersona = new JButton("Eliminar persona");
        JButton listarTareasSinPersonas = new JButton("Listar tareas sin personas");
        JButton cambiarCosteTarea = new JButton("Cambiar coste");

        JPanel panel = new JPanel();
        panel.add(idTarea);
        panel.add(textoIdTarea);
        panel.add(dniPersona);
        panel.add(textoDni);
        panel.add(coste);
        panel.add(textoCoste);
        panel.add(altaTarea);
        panel.add(finalizarTarea);
        panel.add(introducirPersona);
        panel.add(eliminarPersona);
        panel.add(listarTareasSinPersonas);
        panel.add(cambiarCosteTarea);



        JScrollPane parteDatos = new JScrollPane(zonaTextoTareas);
        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        contenedor.add(panel);

        parteDatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        parteDatos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contenedor.add(parteDatos);

        add(contenedor);




        altaTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new PanelAltaTarea(controlador);

            }
        });
        finalizarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        introducirPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        eliminarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listarTareasSinPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PanelListarTareasSinPersonas(controlador);
            }
        });

        cambiarCosteTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }

    public void actualizar(){

    }
}
