package com.biblioteca.integradora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.integradora.dto.UserRequest;
import com.biblioteca.integradora.service.UserService;
import com.biblioteca.integradora.structures.SinglyLinkedList;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService servicio;

    public UserController(UserService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody UserRequest solicitud) {
        return ResponseEntity.ok(servicio.agregarUsuario(solicitud));
    }

    @GetMapping
    public ResponseEntity<SinglyLinkedList> encontrarTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> encontrarPorId(@PathVariable int id) {
        UserRequest encontrado = servicio.buscarPorId(id);
        if (encontrado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(encontrado);
    }
}