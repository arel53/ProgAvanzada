package Aplicacion.Proyecto;

import Aplicacion.Persona.Personas;
import Aplicacion.Resultado.Programa;
import Aplicacion.Tareas.Tareas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    // TODO: deberíais usar la anotación @BeforeEach para construir el proyecto cada vez
Proyecto proyecto;

    @BeforeEach
    void preparaProyecto(){
        proyecto = new Proyecto();
    }

    @org.junit.jupiter.api.Test
    void listarPersonas() {

        // TODO: mejor usar isEmpty para comprobar si están vacías
        assertTrue(proyecto.listarPersonas().isEmpty());
        assertTrue(proyecto.listarTareas().isEmpty());

    }




    @Test
    void altaPersona() {
        for (int i = 0; i < 10000000; i++) {
            // TODO: no tiene sentido crear un nuevo proyecto en cada vuelta, así
            //       es siempre la misma prueba: añadir un elemento a un proyecto vacío
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);
            Personas comparar = proyecto.getPersona(add.getDni());
            assertEquals(add, comparar);
        }





    }

    @Test
    void listarTareas() {

        for (int i = 0; i < 100; i++) {
            // TODO: otra vez no tiene sentido crear un nuevo proyecto en cada vuelta
            Personas add = new Personas(Integer.toString(i), "", "");
            Tareas tarea = new Tareas(Integer.toString(i), "", new LinkedHashSet<>(), add, 1, new Programa(), new LinkedHashSet<>());
            proyecto.altaPersona(add);
            proyecto.altaTarea(tarea);
        }


        for (int i = 0 ; i < 100; i++){

            Tareas encontrarEstado = proyecto.getTarea(Integer.toString(i));

            encontrarEstado.finalizarTarea();

            boolean estadoFinalizado = encontrarEstado.getFinalizado();
            assertTrue(estadoFinalizado);



        }


    }



}