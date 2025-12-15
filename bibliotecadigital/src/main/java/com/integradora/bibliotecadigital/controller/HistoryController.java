package com.integradora.bibliotecadigital.controller;

import com.integradora.bibliotecadigital.model.Book;
import com.integradora.bibliotecadigital.model.HistoryAction;
import com.integradora.bibliotecadigital.model.Loan;
import com.integradora.bibliotecadigital.service.BookService;
import com.integradora.bibliotecadigital.service.HistoryService;
import com.integradora.bibliotecadigital.service.LoanService;
import com.integradora.bibliotecadigital.structures.ArrayQueue;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;
    private final LoanService loanService;
    private final BookService bookService;

    public HistoryController(
            HistoryService historyService,
            LoanService loanService,
            BookService bookService) {
        this.historyService = historyService;
        this.loanService = loanService;
        this.bookService = bookService;
    }

    @PostMapping("/undo")
    public ResponseEntity<String> undo() {

        if (historyService.isEmpty())
            return ResponseEntity.badRequest().body("No hay acciones para deshacer");

        HistoryAction h = historyService.pop();

        if (h.getActionType().equals("CREATE_LOAN")) {

            Loan loan = loanService.buscarPrestamoPorId(h.getLoanId());
            if (loan != null)
                loanService.eliminarPrestamo(loan);

            Book book = bookService.buscarPorId(h.getBookId());
            book.setAvailableCopies(h.getPreviousAvailableCopies());

            return ResponseEntity.ok(
                    "Se deshizo la creacion del prestamo");
        }

        if (h.getActionType().equals("ADD_TO_WAITLIST")) {

            Book book = bookService.buscarPorId(h.getBookId());
            ArrayQueue<Integer> vieja = book.getWaitlist();
            ArrayQueue<Integer> nueva = new ArrayQueue<>();

            while (!vieja.isEmpty()) {
                int current = vieja.poll();
                if (current != h.getUserId())
                    nueva.offer(current);
            }

            book.setWaitlist(nueva);

            return ResponseEntity.ok(
                    "Se deshizo la reserva del usuario en la lista de espera");
        }

        return ResponseEntity.ok("Accion no valida");
    }

@GetMapping
public ResponseEntity<Object[]> getHistory() {
    return ResponseEntity.ok(historyService.getStack().mostrarLista());
}


}
