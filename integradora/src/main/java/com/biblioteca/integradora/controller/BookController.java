package com.biblioteca.integradora.controller;

import com.biblioteca.integradora.dto.BookRequest;
import com.biblioteca.integradora.model.Book;
import com.biblioteca.integradora.service.BookService;
import com.biblioteca.integradora.structures.SinglyLinkedList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService servicio;

    public BookController(BookService servicio) {
        this.servicio = servicio;
    }

    private BookRequest aDTO(Book libro) {
        return new BookRequest(
                libro.getTitle(),
                libro.getAuthor(),
                libro.getTotalCopies()
        );
    }

    private Book aModelo(BookRequest dto) {
        return new Book(
                0,
                dto.getTitle(),
                dto.getAuthor(),
                dto.getTotalCopies(),
                true
        );
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody BookRequest solicitud) {
        return ResponseEntity.ok(servicio.agregarLibro(aModelo(solicitud)));
    }

    @GetMapping
    public ResponseEntity<SinglyLinkedList> encontrarTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRequest> encontrarPorId(@PathVariable int id) {
        Book libro = servicio.buscarPorId(id);
        if (libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(aDTO(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody BookRequest solicitud) {
        Book actualizado = aModelo(solicitud);
        actualizado.setId(id);
        String resultado = servicio.actualizarLibro(id, actualizado);
        if (resultado.equals("Libro no encontrado")) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> cambiarEstadoLogico(@PathVariable int id) {
        String resultado = servicio.cambiarEstadoLogico(id);
        if (resultado.equals("Libro no encontrado")) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/search")
    public ResponseEntity<BookRequest> buscarPorTitulo(@RequestParam String titulo) {
        Book libro = servicio.buscarPorTitulo(titulo);
        if (libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(aDTO(libro));
    }
}