package com.integradora.bibliotecadigital.model;

public class HistoryAction {

    private String actionType;
    private Integer userId;
    private Integer bookId;
    private Integer loanId;
    private Integer previousAvailableCopies;

    public HistoryAction() {
    }

    public HistoryAction(String actionType, Integer userId, Integer bookId, Integer loanId,
            Integer previousAvailableCopies) {
        this.actionType = actionType;
        this.userId = userId;
        this.bookId = bookId;
        this.loanId = loanId;
        this.previousAvailableCopies = previousAvailableCopies;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getPreviousAvailableCopies() {
        return previousAvailableCopies;
    }

    public void setPreviousAvailableCopies(Integer previousAvailableCopies) {
        this.previousAvailableCopies = previousAvailableCopies;
    }

}
