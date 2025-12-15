package com.integradora.bibliotecadigital.dto;

import com.integradora.bibliotecadigital.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;
    private String author;
    private String category;
    private int totalCopies;

    
    public static BookRequest aDTO(Book libro) {
    return new BookRequest(
        libro.getTitle(),
        libro.getAuthor(),
        libro.getCategory(),
        libro.getTotalCopies()
    );
}

}
