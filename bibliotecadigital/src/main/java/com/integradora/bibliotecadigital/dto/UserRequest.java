package com.integradora.bibliotecadigital.dto;

import com.integradora.bibliotecadigital.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String email;


    public static UserRequest aDTO(User usuario){
        return new UserRequest(
            usuario.getName(),
            usuario.getEmail()
        );
    }
}
