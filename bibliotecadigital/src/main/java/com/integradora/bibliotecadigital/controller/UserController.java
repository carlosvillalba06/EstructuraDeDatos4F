package com.integradora.bibliotecadigital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integradora.bibliotecadigital.dto.UserRequest;
import com.integradora.bibliotecadigital.model.User;
import com.integradora.bibliotecadigital.service.UserService;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService servicio;

    public UserController(UserService servicio){
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody UserRequest request){
        User u = User.deRequest(request);
        return ResponseEntity.ok(servicio.agregarUsuario(u));
    }


    @GetMapping
    public ResponseEntity<SinglyLinkedList> encontrarTodos(){

        return ResponseEntity.ok(servicio.obtenerUsuarios());
    }


    
    
    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> encontrarPorId(@PathVariable int id){
        User enontrado = servicio.porId(id);
        if (enontrado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(UserRequest.aDTO(enontrado));
    }
   
}
