

# Aplicación Cliente para Servicio REST de Libros

Este proyecto implementa una aplicación cliente que interactúa con un servicio REST de libros, proporcionando funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar la información de libros.

## Controlador (Controler.java)

El archivo `Controler.java` actúa como un controlador para la interacción con el servicio REST de libros. Proporciona métodos para realizar las siguientes operaciones:

- **Alta de Libro:** Permite agregar un nuevo libro al servicio REST.
- **Borrar Libro:** Permite eliminar un libro del servicio REST mediante su ID.
- **Modificar Libro:** Facilita la modificación de un libro existente mediante su ID.
- **Obtener Libro:** Permite obtener un libro del servicio REST utilizando su ID.
- **Listar Libros:** Permite obtener una lista de todos los libros disponibles en el servicio REST.

## Aplicación Principal (AplicacionClienteRestApplication.java)

El archivo `AplicacionClienteRestApplication.java` representa la clase principal que inicia la aplicación cliente. Utiliza la anotación `@SpringBootApplication` y muestra un menú interactivo para realizar operaciones CRUD en libros utilizando el servicio REST.

## Modelo (Libro.java)

El archivo `Libro.java` define la clase `Libro`, que representa un libro con información detallada como ID, título, editorial y nota. Esta clase se utiliza para modelar objetos de libros en la aplicación cliente que interactúa con el servicio REST.

## Uso

La aplicación cliente permite al usuario realizar las operaciones CRUD en libros a través de un menú interactivo en la consola. Las funcionalidades proporcionadas permiten:

- Agregar nuevos libros.
- Eliminar libros existentes.
- Modificar información de libros.
- Obtener detalles de libros por su ID.
- Listar todos los libros disponibles.

## Tecnologías Utilizadas

- Java
- Spring Boot
- RESTful API

## Autor

- [Jorge Ruiz Martinez] - [https://github.com/n3xun3]
