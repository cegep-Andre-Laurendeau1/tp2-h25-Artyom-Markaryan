package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class DVD extends Document {
    @Column(name = "DURATION")
    private int duration;

    @Column(name = "RATING")
    private int rating;

    private static final int BORROW_DURATION = 1;

    public DVD(String title, String author, LocalDate datePublished, int duration, int rating) {
        super(title, author, datePublished);
        this.duration = duration;
        this.rating = rating;
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
                " }";
    }
}
