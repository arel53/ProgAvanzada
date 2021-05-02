package Aplicacion.Tareas;

import Aplicacion.Tareas.Facturacion;

import java.io.Serializable;

public class Urgente implements calcularFacturacion,Serializable {
    private static final long serialVersionUID=42L;

    static double SOBRE = 1.3;
    @Override
    public double calculoFactura(double coste){

        return coste * SOBRE;

    }
}
