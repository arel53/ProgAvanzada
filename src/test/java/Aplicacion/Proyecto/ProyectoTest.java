package Aplicacion.Proyecto;


import Aplicacion.Fecha.Fecha;
import Aplicacion.Persona.Personas;
import Aplicacion.Tareas.Tareas;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    // TODO: deberíais usar la anotación @BeforeEach para construir el proyecto cada vez
    Proyecto constructor(){
        return new Proyecto();
    }

    @org.junit.jupiter.api.Test
    void listarPersonas() {

        Proyecto proyecto = constructor();
        // TODO: mejor usar isEmpty para comprobar si están vacías
        assertEquals(proyecto.listarPersonas(), new LinkedHashSet<>());
        assertEquals(new LinkedHashSet<>(), proyecto.listarTareas());

    }




    @Test
    void altaPersona() {
        for (int i = 0; i < 100; i++) {
            // TODO: no tiene sentido crear un nuevo proyecto en cada vuelta, así
            //       es siempre la misma prueba: añadir un elemento a un proyecto vacío
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
        // TODO: Los tests unitarios no deben escribir por pantalla
        System.out.println(proyecto.listarPersonas());

        for (int i = 0; i < 10; i++){

            Personas eliminar = proyecto.getPersona(Integer.toString(i));

            proyecto.bajaPersona(eliminar);
            // TODO: Los tests unitarios no deben escribir por pantalla
            System.out.println(proyecto.listarPersonas());
            Personas comparar = proyecto.getPersona(Integer.toString(i));

            // TODO: Los tests unitarios no deben escribir por pantalla
            System.out.println(comparar);

            assertNotEquals(eliminar, comparar);

        }



    }

    @Test
    void listarTareas() {

        Proyecto proyecto = constructor();

        for (int i = 0; i < 100; i++) {
            // TODO: otra vez no tiene sentido crear un nuevo proyecto en cada vuelta
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