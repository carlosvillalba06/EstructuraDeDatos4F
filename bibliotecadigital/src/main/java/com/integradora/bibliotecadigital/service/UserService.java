package com.integradora.bibliotecadigital.service;

import org.springframework.stereotype.Service;

import com.integradora.bibliotecadigital.model.User;
import com.integradora.bibliotecadigital.structures.Node;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;

@Service
public class UserService {

    private final SinglyLinkedList usuarios = new SinglyLinkedList();
    private int siguienteId = 4;

    public UserService(){
        usuarios.add(new User(1, "Joaquin", "joaquin@example.com"));
        usuarios.add(new User(2, "Mario", "mario@example.com"));
        usuarios.add(new User(3, "Ricardo", "ricardo@example.com"));
    }

    public String agregarUsuario(User usuario){

        if (usuario == null) {
            return "Datos no completos";
        }

        if (usuario.getName() == null || usuario.getEmail() == null) {
            return "Debes llenar todos los campos";
        }
        usuario.setId(siguienteId);

        usuarios.add(usuario);
        siguienteId++;
        return "Usuario registrado";

    }

    public SinglyLinkedList obtenerUsuarios(){
        return usuarios;
    }

    public User porId(int id){
        Node actual = usuarios.head;
        while (actual != null) {
            User u = (User) actual.data;
            if (u.getId() == id) {
                return u;
            }
            actual = actual.next;
        }

        return null;
    }
}
