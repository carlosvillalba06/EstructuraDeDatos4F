package com.integradora.bibliotecadigital.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integradora.bibliotecadigital.dto.BookRequest;
import com.integradora.bibliotecadigital.model.Book;
import com.integradora.bibliotecadigital.service.BookService;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService servicio;

    public BookController(BookService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody BookRequest request) {
        Book b = Book.deRequest(request);
        return ResponseEntity.ok(servicio.agregarLibro(b));
    }

    @GetMapping
    public ResponseEntity<SinglyLinkedList> encontrarTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRequest> encontrarPorId(@PathVariable int id) {
        Book libro = servicio.buscarPorId(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BookRequest.aDTO(libro));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody BookRequest request) {
        Book datosBook = Book.deRequest(request);
        datosBook.setId(id);
        String res = servicio.actualizarLibro(id, datosBook);
        if (res.equals("Libro no encontrado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping("/search")
    public ResponseEntity<Book> buscarPorTitulo(@RequestParam String title) {

        Book book = servicio.buscarPorTitulo(title);

        if (book == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(book);
    }

}
