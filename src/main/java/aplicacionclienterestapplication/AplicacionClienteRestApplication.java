package aplicacionclienterestapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static aplicacionclienterestapplication.controler.Controler.*;

@SpringBootApplication
public class AplicacionClienteRestApplication {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        SpringApplication.run(AplicacionClienteRestApplication.class, args);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    altaLibro();
                    break;
                case 2:
                    borrarLibro();
                    break;
                case 3:
                    modificarLibro();
                    break;
                case 4:
                    obtenerLibro();
                    break;
                case 5:
                    listarLibros();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Dar de alta un libro");
        System.out.println("2. Dar de baja un libro por ID");
        System.out.println("3. Modificar un libro por ID");
        System.out.println("4. Obtener un libro por ID");
        System.out.println("5. Listar todos los libros");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }



}
