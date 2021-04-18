package MenuApp;

import Aplicacion.EjecutarMétodos.*;
import Aplicacion.Proyecto.Proyecto;

import java.util.Scanner;

public class Menu {

    // TODO: Mucho cuidad con cómo leéis. Si el nombre del proyecto tiene más de una
    //       palabra, la aplicación se cuelga

    public static void ejecutarMenu() {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;


        System.out.format("\nVas a iniciar un proyecto");
        System.out.format("\nIntorduce el nombre del proyecto: ");
        Proyecto proyecto = Proyecto.iniciarProyecto(sn.nextLine());

        while (!salir) {

            System.out.println(OpcionesMenu.getMenu());
            System.out.format("\n\nElige una opción: ");

            int opcion = sn.nextInt() - 1;
            OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
            sn.nextLine();


            switch (opcionMenu) {
                case ALTA_PERSONAS:
                    System.out.format("\nLa opción elegida es la 1\n\n");
                    AltaPersonas.ejecutarAltaPersonas(sn, proyecto);
                    break;

                case ALTA_TAREA:
                    System.out.format("\nLa opción elegida es la 2\n\n");
                    AltaTareas.ejecutaAltaTareas(sn, proyecto);
                    break;
                case FINALIZAR_TAREA:
                    System.out.format("\nLa opción elegida es la 3\n\n");
                    FinalizarTarea.ejecutarFinalizarTarea(sn, proyecto);
                    break;
                case INTRODUCIR_PERSONA_TAREA:
                    System.out.format("\nLa opción elegida es la 4\n\n");
                    IntroducirPersonaTarea.ejectaIntroducirPersonaTarea(sn, proyecto);
                    break;
                case ELIMINAR_PERSONA_TAREA:
                    System.out.format("\nLa opción elegida es la 5\n\n");
                    EliminarPersonaTarea.ejecutaEliminarPersonaTarea(sn, proyecto);
                    break;
                case LISTAR_PERSONAS_PROYECTO:
                    System.out.format("\nLa opción elegida es la 6\n\n");
                    ListarPersonasProyecto.ejecutaListarPersonasProyecto(proyecto);
                    break;
                case LISTAR_TAREAS_PROYECTO:
                    System.out.format("\nLa opción elegida es la 7\n\n");
                    ListarTareasProyecto.ejecutaListarTareasProyecto(proyecto);
                    break;

                case SALIR:
                    salir = true;
                    System.out.format("\nVas a salir del menú\n\n");
                    break;


                default:
                    System.out.println("Las opciones son entre 1 y 7");
            }


        }

        System.out.format("\nAdiós\n");
    }


}
