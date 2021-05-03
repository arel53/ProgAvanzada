package Aplicacion.Tareas;

import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Resultado.Programa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FacturacionTest {

    private static final double DESC = 0.9;
    private static final double SOBRE = 1.3;

    Proyecto proyecto;
    @BeforeEach
    void preparaProyecto(){
        proyecto = new Proyecto();
    }


    @Test
    void calculoFactura(){
        Facturacion fac1;
        Facturacion fac2;
        Facturacion fac3;
        double coste;
        for (int i = 0; i < 1000; i++) {
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);
            fac1 = new Facturacion(new Urgente());
            fac2 = new Facturacion(new ConsumoInterno());
            fac3 = new Facturacion(new Descuento());
            coste = i * 100;


            Tareas tarea1 = new Tareas(Integer.toString(i), "", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac1.getCalculoFac(),coste,fac1.calculoFactura(coste));
            Tareas tarea2 = new Tareas(Integer.toString(i), "", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac2.getCalculoFac(),coste,fac2.calculoFactura(coste));
            Tareas tarea3 = new Tareas(Integer.toString(i), "", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>(),fac3.getCalculoFac(),coste,fac3.calculoFactura(coste));
            proyecto.altaTarea(tarea1);
            proyecto.altaTarea(tarea2);
            proyecto.altaTarea(tarea3);

            assertEquals(coste* SOBRE, tarea1.getFacturacion());
            assertEquals(coste, tarea2.getFacturacion());
            assertEquals(coste * DESC, tarea3.getFacturacion());
        }
    }

}