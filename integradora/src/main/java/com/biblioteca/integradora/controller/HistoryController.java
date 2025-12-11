package com.biblioteca.integradora.controller;

import com.biblioteca.integradora.service.HistoryService;
import com.biblioteca.integradora.structures.ArrayStack;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService servicio;

    public HistoryController(HistoryService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<ArrayStack> obtenerHistorial() {
        return ResponseEntity.ok(servicio.obtenerHistorial());
    }

    @PostMapping("/undo")
    public ResponseEntity<String> deshacerAccion() {
        // La acción POP del historial ocurre dentro del servicio. 
        return ResponseEntity.ok(servicio.deshacer());
    }
}