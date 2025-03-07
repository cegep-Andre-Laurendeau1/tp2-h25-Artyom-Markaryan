package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class CD extends Document {
    @Column(name = "DURATION")
    private int duration;

    @Column(name = "GENRE")
    private String genre;

    private static final int BORROW_DURATION = 2;

    public CD(String title, String author, LocalDate datePublished, int duration, String genre) {
        super(title, author, datePublished);
        this.duration = duration;
        this.genre = genre;
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
                " }";
    }
}
