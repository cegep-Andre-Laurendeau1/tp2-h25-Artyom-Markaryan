package ca.cal.tp2.modele;

import java.time.LocalDate;

public class BorrowedDocument {
    private final Document document;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private final LocalDate returnDate;
    private String status;

    public BorrowedDocument(Document document, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.document = document;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Document getDocument() {
        return document;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
