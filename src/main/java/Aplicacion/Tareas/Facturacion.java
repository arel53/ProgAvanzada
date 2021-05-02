package Aplicacion.Tareas;

import java.io.Serializable;

public class Facturacion implements calcularFacturacion, Serializable {
    private double coste;
    calcularFacturacion calculoFac;

    public Facturacion(double coste, calcularFacturacion calculoFac){
        this.coste = coste;
        this.calculoFac = calculoFac;
    }

    public double getCoste(){
            return coste;
    }
    public calcularFacturacion getCalculoFac(){
        return calculoFac;
    }

    @Override
    public double calculoFactura(double coste) {
        return calculoFac.calculoFactura(coste);

    }
}
