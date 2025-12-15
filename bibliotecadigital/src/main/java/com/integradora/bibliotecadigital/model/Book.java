package com.integradora.bibliotecadigital.model;

import com.integradora.bibliotecadigital.dto.BookRequest;
import com.integradora.bibliotecadigital.structures.ArrayQueue;

public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private int totalCopies;
    private int availableCopies;
    private Boolean active;
    private ArrayQueue<Integer> waitlist;

    public Book() {

    }

    public Book(int id, String title, String author, String category, int totalCopies, int availableCopies,
            Boolean active, ArrayQueue<Integer> waitlist) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.active = active;
        this.waitlist = waitlist;
    }

    public Book(int id, String title, String author, String category, int totalCopies, int availableCopies,Boolean active) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.active = active;
        this.waitlist = new ArrayQueue<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String auhtor) {
        this.author = auhtor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ArrayQueue<Integer> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(ArrayQueue<Integer> waitlist) {
        this.waitlist = waitlist;
    }

    public static Book deRequest(BookRequest dto) {
    return new Book(
        0, 
        dto.getTitle(),
        dto.getAuthor(),
        dto.getCategory(),
        dto.getTotalCopies(),
        dto.getTotalCopies(), 
        true 
    );
}
}
