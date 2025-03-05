package ca.cal.tp2.modele;

public class Borrower extends User {
    private double finesBalance;

    public Borrower(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    public double getFinesBalance() {
        return finesBalance;
    }
}
