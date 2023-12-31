/**
 * Clase que actúa como controlador para la interacción con el servicio REST de libros.
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) utilizando el servicio REST.
 *
 * @author Jorge Ruiz Martinez
 * @version 1.0
 */
package aplicacionclienterestapplication.controler;
import org.springframework.http.*;
import aplicacionclienterestapplication.model.Libro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la interacción con el servicio REST de libros.
 */
public class Controler {

    /** URL base del servicio REST. */
    private static final String BASE_URL = "http://localhost:8080"; // Ajusta la URL según tu configuración

    /** Objeto RestTemplate para realizar solicitudes REST. */
    private static final RestTemplate restTemplate = new RestTemplate();

    /** Objeto Scanner para la entrada de usuario. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método para agregar un nuevo libro utilizando el servicio REST.
     */
    public static void altaLibro() {
        try {
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

            // Configurar las cabeceras y el cuerpo de la solicitud HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Libro> request = new HttpEntity<>(nuevoLibro, headers);

            // Enviar la solicitud POST y obtener la respuesta
            ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/libros", HttpMethod.POST, request, String.class);

            if (response.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("Libro añadido con éxito.");
            } else {
                System.out.println("Error al intentar agregar el libro.");
            }
        } catch (HttpClientErrorException.BadRequest e) {
            if (e.getRawStatusCode() == 400) {
                System.out.println("Ya existe un libro con el mismo id o título. No se puede agregar.");
            } else {
                System.out.println("Error en la solicitud: " + e.getMessage());
            }
        }
    }

    /**
     * Método para eliminar un libro utilizando el servicio REST.
     */
    public static void borrarLibro() {
        try {
            System.out.print("Introduce el ID del libro a dar de baja: ");
            int id = scanner.nextInt();

            restTemplate.delete(BASE_URL + "/libros/" + id);

            System.out.println("Libro eliminado con éxito.");
        } catch (HttpClientErrorException.BadRequest e) {
            System.out.println("No existe Libro con ese id");
        } catch (Exception e) {
            System.out.println("Error al intentar eliminar el libro: " + e.getMessage());
        }
    }

    /**
     * Método para modificar un libro utilizando el servicio REST.
     */
    public static void modificarLibro() {
        try {
            System.out.print("Introduce el ID del libro a modificar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            ResponseEntity<Libro> response = restTemplate.getForEntity(BASE_URL + "/libros/" + id, Libro.class);

            if (response.getBody() == null) {
                System.out.println("No se encontró un libro con el ID proporcionado. La modificación no es posible.");
                return; // Salir del método si el libro no existe
            }

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
        } catch (Exception e) {
            System.out.println("Error al intentar modificar el libro: " + e.getMessage());
        }
    }

    /**
     * Método para obtener un libro utilizando el servicio REST.
     */
    public static void obtenerLibro() {
        try {
            System.out.print("Introduce el ID del libro a obtener: ");
            int id = scanner.nextInt();
            id = id - 1;

            ResponseEntity<Libro> response = restTemplate.getForEntity(BASE_URL + "/libros/" + id, Libro.class);
            System.out.println(response.getBody());

        } catch (Exception e) {
            System.out.println("Error al intentar obtener el libro: " + e.getMessage());
        }
    }


    /**
     * Método para listar todos los libros utilizando el servicio REST.
     */
    public static void listarLibros() {
        ResponseEntity<Libro[]> response = restTemplate.getForEntity(BASE_URL + "/libros", Libro[].class);
        List<Libro> libros = Arrays.asList(response.getBody());

        System.out.println("Lista de libros:");
        libros.forEach(System.out::println);
    }
}
