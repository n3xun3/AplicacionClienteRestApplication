package aplicacionclienterestapplication.controler;

import aplicacionclienterestapplication.model.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controler {

    private static final String BASE_URL = "http://localhost:8080"; // Ajusta la URL según tu configuración
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Scanner scanner = new Scanner(System.in);

    public static void altaLibro() {
        try{
            System.out.println("Introduce los datos del nuevo libro:");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Editorial: ");
            String editorial = scanner.nextLine();
            System.out.print("Nota: ");
            int nota = scanner.nextInt();

            Libro nuevoLibro = new Libro(id, titulo, editorial, nota);
            ResponseEntity<Libro> response = restTemplate.postForEntity(BASE_URL + "/libros", nuevoLibro, Libro.class);

            System.out.println("Libro añadido con éxito. ID asignado: " + response.getBody().getId());

        }catch (HttpClientErrorException.BadRequest e) {
            // Manejar la excepción de BadRequest aquí
            if (e.getRawStatusCode() == 400) {
                System.out.println("Ya existe un libro con el mismo id. No se puede agregar.");
            } else {
                System.out.println("Error en la solicitud: " + e.getMessage());
            }
        } catch (Exception e) {
            // Manejar otras excepciones aquí
            System.out.println("Error en la solicitud: " + e.getMessage());
        }

    }

    public static void borrarLibro() {
        System.out.print("Introduce el ID del libro a dar de baja: ");
        int id = scanner.nextInt();

        restTemplate.delete(BASE_URL + "/libros/" + id);

        System.out.println("Libro eliminado con éxito.");
    }

    public static void modificarLibro() {
        System.out.print("Introduce el ID del libro a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Introduce los nuevos datos del libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Nota: ");
        int nota = scanner.nextInt();

        Libro libroModificado = new Libro(id, titulo, editorial, nota);
        restTemplate.put(BASE_URL + "/libros/" + id, libroModificado);

        System.out.println("Libro modificado con éxito.");
    }

    public static void obtenerLibro() {
        System.out.print("Introduce el ID del libro a obtener: ");
        int id = scanner.nextInt();

        ResponseEntity<Libro> response = restTemplate.getForEntity(BASE_URL + "/libros/" + id, Libro.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Libro encontrado: " + response.getBody());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void listarLibros() {
        ResponseEntity<Libro[]> response = restTemplate.getForEntity(BASE_URL + "/libros", Libro[].class);
        List<Libro> libros = Arrays.asList(response.getBody());

        System.out.println("Lista de libros:");
        libros.forEach(System.out::println);
    }
}
