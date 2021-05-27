package Aplicacion.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaEmergente extends JDialog {


    VentanaEmergente(JFrame padre,String infoVentanaEm, boolean bloquea){
        super(padre,bloquea);
        JPanel panel = new JPanel();
        panel.add(new JLabel(infoVentanaEm));
        add(panel, BorderLayout.CENTER);
        setTitle("Error");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
