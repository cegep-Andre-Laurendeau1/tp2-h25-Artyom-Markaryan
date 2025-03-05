package ca.cal.tp2.modele;

import java.time.LocalDate;

public abstract class Document {
    protected String title;
    protected String author;
    protected LocalDate datePublished;
    protected int copies;

    public Document(String title, String author, LocalDate datePublished, int copies) {
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public int getCopies() {
        return copies;
    }
}
