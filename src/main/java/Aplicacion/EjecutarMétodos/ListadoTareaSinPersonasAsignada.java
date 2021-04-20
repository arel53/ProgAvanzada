package Aplicacion.EjecutarMétodos;

import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Tareas.Tareas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ListadoTareaSinPersonasAsignada{

    public static void ejecutarListadoPersonasSinTareaAsignada(Proyecto proyecto){

        List<Tareas> tareasSinPersonaAsignada = new LinkedList<>();

        tareasSinPersonaAsignada = UtilidadesParaListas.elementosConListaVacia(proyecto.listarTareas());

        for (Tareas tareas : tareasSinPersonaAsignada){
            System.out.format("Titulo --> %s\n",tareas.getClave());
        }
        System.out.format("\n");
    }
}
