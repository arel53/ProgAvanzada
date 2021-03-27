package MenuApp;

import Aplicacion.Personas;
import Aplicacion.Proyecto;
import Aplicacion.Tareas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        System.out.format("\nVas a iniciar un proyecto");
        System.out.format("\nIntorduce el nombre del proyecto: ");
        Proyecto proyecto = new Proyecto(sn.nextLine());

        while (!salir){
            System.out.format("\nOpciones :\n\n");
            System.out.println("1. Dar de alta a las personas que trabajan en el proyecto.");
            System.out.println("2. Dar de alta tareas.");
            System.out.println("3. Marcar tarea como finalizada.");
            System.out.println("4. Introducir o eliminar una persona de una tarea.");
            System.out.println("5. Listar las personas asignadas a un proyecto.");
            System.out.println("6. Listar las tareas de un proyecto.");
            System.out.println("7. Cerrar menú.");

            try {
                System.out.format("\n\nElige una opción: ");
                opcion = sn.nextInt();


                switch (opcion) {
                    case 1:
                        System.out.format("\nVas a dar de alta a personas que trabajan en el proyecto");
                        System.out.format("\nIntorduce el nombre de la persona y sus datos (nombre, correo y sus tareas) respectivamente: ");
                        System.out.format("\nIntroduce el nombre --> ");
                        String nombre = sn.nextLine();
                        System.out.format("\nIntroduce el correo --> ");
                        String correo = sn.nextLine();
                        System.out.format("\nAhora vas a introducir las tareas que debe realizar una a una (si no quieres introducir más escribe la letra q)--> ");
                        boolean finalizado = false;
                        int contador = 1;
                        List<Tareas> tareas = new ArrayList<>();
                        while (finalizado){
                            System.out.format("Tarea " + contador++);

                        }

                        proyecto.altaPersona(new Personas(nombre,correo));

                        break;
                    case 2:
                        System.out.format("\nLa opción elegida es la 2");
                        break;
                    case 3:
                        System.out.format("\nLa opción elegida es la 3");
                        break;
                    case 4:
                        System.out.format("\nLa opción elegida es la 4");
                        break;
                    case 5:
                        System.out.format("\nLa opción elegida es la 5");
                        break;
                    case 6:
                        System.out.format("\nLa opción elegida es la 6");
                        break;
                    case 7:
                        System.out.format("\nLa opción elegida es la 7");
                        System.out.format("\nVas a salir del menú\n");
                        salir = true;
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
