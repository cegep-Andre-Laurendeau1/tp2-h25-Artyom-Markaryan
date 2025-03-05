package ca.cal.tp2.modele;

import java.time.LocalDate;

public abstract class Document {
    protected String title;
    protected String author;
    protected LocalDate datePublished;
    protected String documentType;
    protected int copies;

    public Document(String title, String author, LocalDate datePublished, String documentType, int copies) {
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.documentType = documentType;
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

    public String getDocumentType() {
        return documentType;
    }

    public int getCopies() {
        return copies;
    }
}
