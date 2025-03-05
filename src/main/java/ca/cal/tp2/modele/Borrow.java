package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.List;

public class Borrow {
    private final LocalDate borrowDate;
    private final List<BorrowedDocument> borrowedDocuments;
    private String status;

    public Borrow(LocalDate borrowDate, List<BorrowedDocument> borrowedDocuments, String status) {
        this.borrowDate = borrowDate;
        this.borrowedDocuments = borrowedDocuments;
        this.status = status;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public List<BorrowedDocument> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public int getTotalDocuments() {
        return borrowedDocuments.size();
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
