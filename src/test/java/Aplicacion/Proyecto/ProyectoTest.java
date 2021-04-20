package Aplicacion.Proyecto;

import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Resultado.Programa;
import Aplicacion.Tareas.Tareas;
import jdk.jshell.execution.Util;
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
    void ListadoTareaSinPersonas() {

        Personas add1 = new Personas("1", "", "");
        Personas add2 = new Personas("2", "", "");
        Personas add3 = new Personas("3", "", "");
        List<Personas> personas = new LinkedList<>();
        personas.add( add1);
        personas.add(add2);

        Tareas tarea1 = new Tareas("uno", "", personas, add1, 1, new Programa(), new LinkedList<>());
        Tareas tarea2 = new Tareas("dos", "", new LinkedList<>(), new Personas(), 1, new Programa(), new LinkedList<>());
        Tareas tarea3 = new Tareas("tres", "", new LinkedList<>(), new Personas(), 1, new Programa(), new LinkedList<>());
        Tareas tarea4 = new Tareas("cuatro", "", personas, add2, 1, new Programa(), new LinkedList<>());
        proyecto.altaPersona(add1);
        proyecto.altaPersona(add2);
        proyecto.altaPersona(add3);
        proyecto.altaTarea(tarea1);
        proyecto.altaTarea(tarea2);
        proyecto.altaTarea(tarea3);
        proyecto.altaTarea(tarea4);

        List<Tareas> tareasSin = new LinkedList<>();
        tareasSin.add(tarea2);
        tareasSin.add(tarea3);


        assertEquals(UtilidadesParaListas.elementosConListaVacia(proyecto.tareas), tareasSin);
    }

    @Test
    void altaPersona() {
        for (int i = 0; i < 1000; i++) {
            // TODO: no tiene sentido crear un nuevo proyecto en cada vuelta, así
            //       es siempre la misma prueba: añadir un elemento a un proyecto vacío
            Personas add = new Personas(Integer.toString(i), "", "");
            proyecto.altaPersona(add);
            Personas comparar = proyecto.getPersona(add.getClave());
            assertEquals(add, comparar);
        }





    }

    @Test
    void listarPersonasNoResponsablesTareas() {

            List<Tareas> responsable = new LinkedList<>();
            responsable.add(new Tareas());

            Personas add1 = new Personas("1", "", "", responsable);
            Personas add2 = new Personas("2","","");
            Tareas tarea1 = new Tareas("con", "", new LinkedList<>(), add1, 1, new Programa(), new LinkedList<>());
            Tareas tarea2 = new Tareas("sin", "", new LinkedList<>(), add1, 1, new Programa(), new LinkedList<>());
            proyecto.altaPersona(add1);
            proyecto.altaPersona(add2);
            proyecto.altaTarea(tarea1);
            proyecto.altaTarea(tarea2);

            List<Personas> noResponsables = new LinkedList<>();
            noResponsables.add(add2);
            assertEquals(noResponsables,UtilidadesParaListas.elementosConListaVacia(proyecto.personas));

    }

    @Test
    void listarTareas() {

        for (int i = 0; i < 100; i++) {
            // TODO: otra vez no tiene sentido crear un nuevo proyecto en cada vuelta
            Personas add = new Personas(Integer.toString(i), "", "");
            Tareas tarea = new Tareas(Integer.toString(i), "", new LinkedList<>(), add, 1, new Programa(), new LinkedList<>());
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