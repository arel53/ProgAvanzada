package MenuApp;

import Aplicacion.EjecutarMétodos.*;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Proyecto.Proyecto;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // TODO: Mucho cuidad con cómo leéis. Si el nombre del proyecto tiene más de una
    //       palabra, la aplicación se cuelga

    public static void ejecutarMenu() throws IOException, ClassNotFoundException {




        Scanner sn = new Scanner(System.in);

        boolean salir = false;


        System.out.format("\nVas a iniciar un proyecto");
        System.out.format("\nIntorduce el nombre del proyecto: ");
        String fichero = sn.nextLine();
        Proyecto proyecto = Proyecto.iniciarProyecto(fichero);
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("proy.bin"));
            proyecto = (Proyecto) ois.readObject();
            ois.close();
        }catch (Exception e){
            System.out.format(e.getMessage());
        }




        while (!salir) {


            System.out.println(OpcionesMenu.getMenu());
            System.out.format("\n\nElige una opción: ");
            try {

                int opcion = sn.nextInt() - 1;
                OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);


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
                        System.out.println("Las opciones son entre 1 y 10");
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.format("\nDebes introducir un número entre 1 y 10");
                sn.nextLine();
            }


        }

    }


}
