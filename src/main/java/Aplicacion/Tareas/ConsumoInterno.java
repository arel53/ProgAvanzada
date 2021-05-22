package Aplicacion.Tareas;


import java.io.Serializable;

public class ConsumoInterno implements calcularFacturacion,Serializable{
    private static final long serialVersionUID=42L;

    @Override
    public double calculoFactura(double coste) {

        return coste;

    }
}
