package ca.cal.tp2.modele;

import java.time.LocalDate;

public class CD extends Document {
    private final int duration;
    private final String genre;
    private static final int BORROW_DURATION = 2;

    public CD(String title, String author, LocalDate datePublished, int copies, int duration, String genre) {
        super(title, author, datePublished, copies);
        this.duration = duration;
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public static int getBorrowDuration() {
        return BORROW_DURATION;
    }

    @Override
    public String toString() {
        return "CD {" +
                " Titre: " + super.title +
                ", Artiste: " + super.author +
                ", Genre: " + this.genre +
                ", Durée: " + this.duration +
                ", Date de publication: " + super.datePublished +
                ", Exemplaires: " + copies +
                " }";
    }
}
