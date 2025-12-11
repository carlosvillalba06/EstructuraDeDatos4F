package com.biblioteca.integradora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.integradora.service.LoanService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final LoanService servicio;

    public ReservationController(LoanService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/{bookId}/position/{userId}")
    public ResponseEntity<String> obtenerPosicion(
            @PathVariable int idLibro,
            @PathVariable int idUsuario) {

        int posicion = servicio.obtenerPosicionReserva(idLibro, idUsuario); 

        if (posicion == -1)
            return ResponseEntity.ok("El usuario no tiene reserva en este libro");

        return ResponseEntity.ok("Posición en lista: " + posicion);
    }

    @DeleteMapping("/{bookId}/{userId}")
    public ResponseEntity<String> cancelar(@PathVariable int idLibro, @PathVariable int idUsuario) {
        return ResponseEntity.ok(servicio.cancelarReserva(idLibro, idUsuario));
    }
}