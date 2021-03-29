package Aplicacion.Proyecto;


import Aplicacion.Fecha.Fecha;
import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {


    Proyecto constructor(){
        return new Proyecto();
    }

    @org.junit.jupiter.api.Test
    void listarPersonas() {

        Proyecto proyecto = constructor();
        assertEquals(proyecto.listarPersonas(), new LinkedHashSet<>());
        assertEquals(new LinkedHashSet<>(), proyecto.listarTareas());

    }




    @Test
    void altaPersona() {
        for (int i = 0; i < 100; i++) {
            Proyecto proyecto = constructor();
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);
            Personas comparar = proyecto.getPersona(add.getDni());
            assertEquals(add, comparar);
        }





    }
    @Test
    void bajaPersona(){


        Proyecto proyecto = constructor();
        for (int i = 0; i < 10; i++) {
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);

        }
        System.out.println(proyecto.listarPersonas());

        for (int i = 0; i < 10; i++){

            Personas eliminar = proyecto.getPersona(Integer.toString(i));

            proyecto.bajaPersona(eliminar);
            System.out.println(proyecto.listarPersonas());
            Personas comparar = proyecto.getPersona(Integer.toString(i));

            System.out.println(comparar);

            assertNotEquals(eliminar, comparar);

        }



    }

    @Test
    void listarTareas() {

        Proyecto proyecto = constructor();

        for (int i = 0; i < 100; i++) {
            proyecto = constructor();
            Personas add = new Personas(Integer.toString(i), "", "");
            Tareas tarea = new Tareas(Integer.toString(i), "", new LinkedHashSet<Personas>(), add, 1, "", new LinkedHashSet<String>());
            proyecto.altaPersona(add);
            proyecto.altaTarea(tarea);
        }


        for (int i = 0 ; i < 100; i++){

            Tareas encontrarEstado = proyecto.getTarea(Integer.toString(i));

            encontrarEstado.finalizarTarea();

            String estadoFinalizado = encontrarEstado.getFinalizado();
            assertEquals(estadoFinalizado, "Finalizado");



        }


    }



}