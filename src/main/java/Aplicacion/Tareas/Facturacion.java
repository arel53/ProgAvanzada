package Aplicacion.Tareas;

import java.io.Serializable;

public class Facturacion implements Serializable {
    private static final long serialVersionUID=42L;

    calcularFacturacion calculoFac;

    public Facturacion(calcularFacturacion calculoFac){
        this.calculoFac = calculoFac;
    }

    public calcularFacturacion getCalculoFac(){
        return calculoFac;
    }



    public double calculoFactura(double coste) {
        return calculoFac.calculoFactura(coste);
    }
}
