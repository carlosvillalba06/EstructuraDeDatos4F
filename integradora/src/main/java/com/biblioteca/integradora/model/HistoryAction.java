package com.biblioteca.integradora.model;

public class HistoryAction {

    public enum ActionType {
        CREATE_LOAN,
        RETURN_LOAN,
        ADD_TO_WAITLIST,
        AUTO_LOAN,
        REMOVE_FROM_WAITLIST
    }

    private ActionType type;
    private int loanId;
    private int userId;
    private int bookId;

    public HistoryAction() {
    }

    public HistoryAction(ActionType type, int loanId, int userId, int bookId) {
        this.type = type;
        this.loanId = loanId;
        this.userId = userId;
        this.bookId = bookId;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
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

    @Override
    public String toString() {
        return "HistoryAction{" +
                "type=" + type +
                ", loanId=" + loanId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}
