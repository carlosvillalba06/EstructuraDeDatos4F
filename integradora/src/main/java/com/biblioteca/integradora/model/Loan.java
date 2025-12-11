package com.biblioteca.integradora.model;

public class Loan {

    private int id;
    private int userId;
    private int bookId;
    private boolean returned;
    
    public Loan() {
    }

    public Loan(int id, int userId, int bookId, boolean returned) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Loan [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", returned=" + returned + "]";
    }

    
}
