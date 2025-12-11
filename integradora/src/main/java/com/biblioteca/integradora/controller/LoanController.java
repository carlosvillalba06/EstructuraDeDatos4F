package com.biblioteca.integradora.controller;

import com.biblioteca.integradora.service.LoanService;
import com.biblioteca.integradora.structures.SinglyLinkedList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService servicio;

    public LoanController(LoanService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<String> crearPrestamo(
            @RequestParam int idUsuario,
            @RequestParam int idLibro
    ) {
        return ResponseEntity.ok(
                servicio.crearPrestamo(idUsuario, idLibro)
        );
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<String> devolverPrestamo(@PathVariable int idPrestamo) {
        // Esta acción desencadena el chequeo de la ArrayQueue. 
        return ResponseEntity.ok(servicio.devolverLibro(idPrestamo));
    }

    @GetMapping("/active")
    public ResponseEntity<SinglyLinkedList> obtenerPrestamosActivos() {
        return ResponseEntity.ok(servicio.obtenerPrestamosActivos());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<SinglyLinkedList> obtenerPrestamosPorUsuario(@PathVariable int idUsuario) {
        return ResponseEntity.ok(servicio.obtenerPrestamosPorUsuario(idUsuario));
    }
}