/**
 * Clase que representa un libro con información como ID, título, editorial y nota.
 * Se utiliza para modelar objetos de libros en la aplicación cliente.
 *
 * @author Tu Nombre
 * @version 1.0
 */
package aplicacionclienterestapplication.model;

/**
 * Clase que representa un libro con información como ID, título, editorial y nota.
 */
public class Libro {

    /** Identificador único del libro. */
    private int id;

    /** Título del libro. */
    private String titulo;

    /** Editorial del libro. */
    private String editorial;

    /** Nota asignada al libro. */
    private int nota;

    /** Constructor predeterminado. */
    public Libro() {
        super();
    }

    /**
     * Constructor que inicializa un libro con la información proporcionada.
     *
     * @param id        Identificador único del libro.
     * @param titulo    Título del libro.
     * @param editorial Editorial del libro.
     * @param nota      Nota asignada al libro.
     */
    public Libro(int id, String titulo, String editorial, int nota) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.nota = nota;
    }

    /**
     * Obtiene el identificador único del libro.
     *
     * @return Identificador único del libro.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param id Identificador único del libro.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return Editorial del libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial Editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene la nota asignada al libro.
     *
     * @return Nota asignada al libro.
     */
    public int getNota() {
        return nota;
    }

    /**
     * Establece la nota asignada al libro.
     *
     * @param nota Nota asignada al libro.
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Representación en cadena del objeto libro.
     *
     * @return Cadena que representa el objeto libro.
     */
    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", nota=" + nota + "]";
    }
}
