package ca.cal.tp2.modele;

import java.time.LocalDate;

public class Borrow {
    private final LocalDate borrowDate;
    private final int totalDocuments;
    private String status;

    public Borrow(LocalDate borrowDate, int totalItems, String status) {
        this.borrowDate = borrowDate;
        this.totalDocuments = totalItems;
        this.status = status;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public int getTotalDocuments() {
        return totalDocuments;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
