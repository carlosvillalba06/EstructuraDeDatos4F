package com.integradora.bibliotecadigital.controller;

import com.integradora.bibliotecadigital.model.Book;
import com.integradora.bibliotecadigital.service.BookService;
import com.integradora.bibliotecadigital.structures.ArrayQueue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final BookService bookService;

    public ReservationController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> obtenerReservas(@PathVariable int bookId) {

        Book book = bookService.buscarPorId(bookId);
        if (book == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(book.getWaitlist());
    }

    @DeleteMapping
    public ResponseEntity<String> cancelarReserva(
            @RequestParam int userId,
            @RequestParam int bookId
    ) {

        Book book = bookService.buscarPorId(bookId);
        if (book == null)
            return ResponseEntity.notFound().build();

        ArrayQueue<Integer> vieja = book.getWaitlist();
        ArrayQueue<Integer> nueva = new ArrayQueue<>();

        boolean eliminado = false;

        while (!vieja.isEmpty()) {
            int actual = vieja.poll();
            if (actual != userId)
                nueva.offer(actual);
            else
                eliminado = true;
        }

        book.setWaitlist(nueva);

        return ResponseEntity.ok(
                eliminado ? "Reserva cancelada" : "El usuario no estaba en la lista"
        );
    }
}


