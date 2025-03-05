package ca.cal.tp2.modele;

import java.time.LocalDate;

public class DVD extends Document {
    private final int duration;
    private final int rating;
    private static final int BORROW_DURATION = 1;

    public DVD(String title, String author, LocalDate datePublished, String documentType, int copies, int duration, int rating) {
        super(title, author, datePublished, documentType, copies);
        this.duration = duration;
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public static int getBorrowDuration() {
        return BORROW_DURATION;
    }

    @Override
    public String toString() {
        return "DVD {" +
                " Titre: " + super.title +
                ", Directeur: " + super.author +
                ", Classement: " + this.rating +
                ", Durée: " + this.duration +
                ", Date de publication: " + super.datePublished +
                ", Exemplaires: " + copies +
                " }";
    }
}
