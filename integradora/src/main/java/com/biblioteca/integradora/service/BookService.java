package com.biblioteca.integradora.service;

import com.biblioteca.integradora.model.Book;
import com.biblioteca.integradora.structures.SinglyLinkedList;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final SinglyLinkedList catalogo = new SinglyLinkedList();

    public BookService() {
        catalogo.add(new Book(1, "El principito", "Antoine de Saint-Exupéry", 3, true));
        catalogo.add(new Book(2, "Cien años de soledad", "Gabriel García Márquez", 3, true));
        catalogo.add(new Book(3, "1984", "George Orwell", 3, true));
    }

    public String agregarLibro(Book libro) {
        if (buscarPorId(libro.getId()) != null)
            return "Ya existe un libro con ese ID";

        catalogo.add(libro);
        return "Libro registrado";
    }

    public SinglyLinkedList obtenerTodos() {
        return catalogo;
    }

    public Book buscarPorId(int id) {
        var actual = catalogo.head;
        while (actual != null) {
            Book libro = (Book) actual.data;
            if (libro.getId() == id)
                return libro;
            actual = actual.next;
        }
        return null;
    }

    public Book buscarPorTitulo(String titulo) {
        var actual = catalogo.head;
        while (actual != null) {
            Book libro = (Book) actual.data;
            if (libro.getTitle() != null && libro.getTitle().equalsIgnoreCase(titulo))
                return libro;
            actual = actual.next;
        }
        return null;
    }

    public String actualizarLibro(int id, Book datosNuevos) {
        Book libro = buscarPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setTitle(datosNuevos.getTitle());
        libro.setAuthor(datosNuevos.getAuthor());
        libro.setTotalCopies(datosNuevos.getTotalCopies());

        if (libro.getAvailableCopies() > libro.getTotalCopies())
            libro.setAvailableCopies(libro.getTotalCopies());

        libro.setStatus(datosNuevos.isStatus());

        return "Libro actualizado";
    }

    public String cambiarEstadoLogico(int id) {
        Book libro = buscarPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setStatus(!libro.isStatus());
        return "Estado actualizado";
    }

    public String darDeBaja(int id) {
        Book libro = buscarPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setStatus(false);
        return "Libro dado de baja";
    }
}
