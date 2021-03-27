package MenuApp;

import Aplicacion.EjecutarMétodos.AltaPersonas;
import Aplicacion.EjecutarMétodos.AltaTareas;
import Aplicacion.Proyecto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);

        boolean salir = false;


        System.out.format("\nVas a iniciar un proyecto");
        System.out.format("\nIntorduce el nombre del proyecto: ");
        Proyecto proyecto = Proyecto.iniciarProyecto(sn.next());

        while (!salir){
            try {

                System.out.println(OpcionesMenu.getMenu());
                System.out.format("\n\nElige una opción: ");

                int opcion = sn.nextInt() - 1;
                OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);


                switch (opcionMenu) {
                    case ALTA_PERSONAS:
                        System.out.format("\nLa opción elegida es la 1\n");
                        AltaPersonas.ejecutarAltaPersonas(sn,proyecto);
                        break;
                    case ALTA_TAREA:
                        System.out.format("\nLa opción elegida es la 2\n");
                        AltaTareas.ejecutaAltaTareas(sn,proyecto);
                        break;
                    case FINALIZAR_TAREA:
                        System.out.format("\nLa opción elegida es la 3");
                        break;
                    case INTRODUCIR_PERSONA_TAREA:
                        System.out.format("\nLa opción elegida es la 4");
                        break;
                    case ELIMINAR_PERSONA_TAREA:
                        System.out.format("\nLa opción elegida es la 5");
                        break;
                    case LISTAR_PERSONAS_PROYECTO:
                        System.out.format("\nLa opción elegida es la 6");
                        break;
                    case LISTAR_TAREAS_PROYECTO:
                        System.out.format("\nLa opción elegida es la 7");
                        System.out.format("\nVas a salir del menú\n");
                        salir = true;
                        break;

                    case SALIR:
                        salir = true;
                        break;


                    default:
                        System.out.println("Las opciones son entre 1 y 8");
                }

            }
            catch (InputMismatchException e){
                System.out.format("\nDebes introducir un número\n");
                sn.next();
            }

        }

        System.out.format("\nAdiós\n");
    }




}
