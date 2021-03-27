package MenuApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        while (!salir){
            System.out.format("\nOpciones :\n\n");
            System.out.println("1. Iniciar proyecto.");
            System.out.println("2. Dar de alta a las personas que trabajan en el proyecto.");
            System.out.println("3. Dar de alta tareas.");
            System.out.println("4. Marcar tarea como finalizada.");
            System.out.println("5. Introducir o eliminar una persona de una tarea.");
            System.out.println("6. Listar las personas asignadas a un proyecto.");
            System.out.println("7. Listar las tareas de un proyecto.");
            System.out.println("8. Cerrar menú.");

            try {
                System.out.format("\n\nElige una opción: ");
                opcion = sn.nextInt();


                switch (opcion) {

                    case 1:
                        System.out.format("\nLa opción elegida es la 1");
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
                        break;
                    case 8:
                        System.out.format("\nLa opción elegida es la 8");
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
