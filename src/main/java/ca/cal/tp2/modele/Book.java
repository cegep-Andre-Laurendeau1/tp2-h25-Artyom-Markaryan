package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Book extends Document {
    @Column(name = "EDITOR")
    private String editor;

    @Column(name = "PAGES")
    private int pages;

    private static final int BORROW_DURATION = 3;

    public Book(String title, String author, LocalDate datePublished, String editor, int pages) {
        super(title, author, datePublished);
        this.editor = editor;
        this.pages = pages;
    }

    public static int getBorrowDuration() {
        return BORROW_DURATION;
    }

    @Override
    public String toString() {
        return "Livre {" +
                " Titre: " + super.title +
                ", Auteur: " + super.author +
                ", Éditeur: " + this.editor +
                ", Nombre de pages: " + this.pages +
                ", Date de publication: " + super.datePublished +
                " }";
    }
}
