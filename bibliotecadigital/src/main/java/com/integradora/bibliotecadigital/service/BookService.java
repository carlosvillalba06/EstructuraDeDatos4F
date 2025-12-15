package com.integradora.bibliotecadigital.service;
import org.springframework.stereotype.Service;

import com.integradora.bibliotecadigital.model.Book;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;
@Service
public class BookService {

    private final SinglyLinkedList libros = new SinglyLinkedList();
    private int siguienteId = 4;

    public BookService(){
        libros.add(new Book(1, "El principito", "Antoine de Saint-Exupéry", "Ficcion", 1, 1,true));
        libros.add(new Book(2, "Cien años de soledad", "Gabriel Garcia Márquez", "Novela", 3, 3, true));
        libros.add(new Book(3, "1984", "George Orwell", "Distopia", 3, 3, true));
    }

    public String agregarLibro(Book book){
        book.setId(siguienteId);
        libros.add(book);
        siguienteId++;
        return "Libro agregado";
    }

    public SinglyLinkedList obtenerTodos(){
        return libros;
    }

    public Book buscarPorId(int id) {
        var actual = libros.head;
        while (actual != null) {
            Book libro = (Book) actual.data;  
            if (libro.getId() == id)
                return libro;
            actual = actual.next;
        }
        return null;
    }

    public Book buscarPorTitulo(String titulo) {
        var actual = libros.head;
        while (actual != null) {
            Book libro = (Book) actual.data;
            if (libro.getTitle().equalsIgnoreCase(titulo))
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
        libro.setCategory(datosNuevos.getCategory());
        libro.setTotalCopies(datosNuevos.getTotalCopies());
        libro.setAvailableCopies(datosNuevos.getTotalCopies());

        return "Libro actualizado";
    }
}
