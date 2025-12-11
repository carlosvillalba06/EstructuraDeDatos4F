package com.biblioteca.integradora.service;

import com.biblioteca.integradora.dto.UserRequest;
import com.biblioteca.integradora.structures.SinglyLinkedList;
import com.biblioteca.integradora.structures.Node;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final SinglyLinkedList listaUsuarios = new SinglyLinkedList();

    public UserService() {
        listaUsuarios.add(new UserRequest(1, "Carlos"));
        listaUsuarios.add(new UserRequest(2, "Juan"));
        listaUsuarios.add(new UserRequest(3, "Pedro"));
    }

    public String agregarUsuario(UserRequest solicitud) {
        if (solicitud == null)
            return "Datos inválidos";

        if (solicitud.getId() <= 0)
            return "ID inválido";

        if (solicitud.getName() == null || solicitud.getName().trim().isEmpty())
            return "Nombre requerido";

        if (buscarPorId(solicitud.getId()) != null)
            return "Ese ID ya existe";

        listaUsuarios.add(solicitud);
        return "Usuario registrado";
    }

    public SinglyLinkedList obtenerTodos() {
        return listaUsuarios;
    }

    public UserRequest buscarPorId(int id) {
        // La lógica de búsqueda manual sobre la SinglyLinkedList
        Node actual = listaUsuarios.head; 

        while (actual != null) {
            UserRequest usuario = (UserRequest) actual.data;
            if (usuario.getId() == id) {
                return usuario;
            }
            actual = actual.next;
        }

        return null;
    }
}