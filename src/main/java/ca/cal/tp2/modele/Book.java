package ca.cal.tp2.modele;

import java.time.LocalDate;

public class Book extends Document {
    private final String editor;
    private final int pages;
    private static final int BORROW_DURATION = 3;

    public Book(String title, String author, LocalDate datePublished, String documentType, int copies, String editor, int pages) {
        super(title, author, datePublished, documentType, copies);
        this.editor = editor;
        this.pages = pages;
    }

    public String getEditor() {
        return editor;
    }

    public int getPages() {
        return pages;
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
                ", Exemplaires: " + copies +
                " }";
    }
}
