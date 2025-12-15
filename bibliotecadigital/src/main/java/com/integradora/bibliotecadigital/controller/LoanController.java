package com.integradora.bibliotecadigital.controller;

import com.integradora.bibliotecadigital.dto.LoanRequest;
import com.integradora.bibliotecadigital.service.LoanService;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<?> crearPrestamo(@RequestBody LoanRequest body) {
        return loanService.crearPrestamo(body.userId, body.bookId, body.fecha);
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<String> devolverLibro(@PathVariable int loanId) {
        return loanService.devolverLibro(loanId);
    }

    @GetMapping("/active")
    public ResponseEntity<SinglyLinkedList> prestamosActivos() {
        return ResponseEntity.ok(loanService.obtenerPrestamosActivos());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<SinglyLinkedList> prestamosPorUsuario(@PathVariable int userId) {
        return ResponseEntity.ok(loanService.obtenerPrestamosPorUsuario(userId));
    }
}
