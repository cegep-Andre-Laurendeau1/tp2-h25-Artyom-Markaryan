package ca.cal.tp2.modele;

import java.util.List;

public class Borrower extends User {
    private List<Borrow> borrowsList;
    private double finesBalance;

    public Borrower(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    public List<Borrow> getBorrowsList() {
        return borrowsList;
    }

    public double getFinesBalance() {
        return finesBalance;
    }
}
