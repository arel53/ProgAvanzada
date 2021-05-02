package Aplicacion.Tareas;

import Aplicacion.Tareas.Facturacion;


import java.io.Serializable;

public class ConsumoInterno implements calcularFacturacion,Serializable{

    @Override
    public double calculoFactura(double coste) {

        return coste;

    }
}
