package com.integradora.bibliotecadigital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    public int userId;
    public int bookId;
    public String fecha;
}
