package ca.cal.tp2.service;

import ca.cal.tp2.modele.Librarian;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.persistance.LibrarianRepository;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.exception.DatabaseException;
import java.util.List;

public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final DocumentRepository documentRepository;

    public LibrarianService() {
        this.librarianRepository = new LibrarianRepository();
        this.documentRepository = new DocumentRepository();
    }

    public void addLibrarian(Librarian librarian) throws DatabaseException {
        librarianRepository.save(librarian);
    }

    public Librarian getLibrarian(int id) throws DatabaseException {
        return librarianRepository.findById(id);
    }

    public void addDocument(Document document) throws DatabaseException {
        documentRepository.save(document);
    }

    public Document getDocumentById(int id) throws DatabaseException {
        return documentRepository.findById(id);
    }

    public List<Document> getDocumentsByTitle(String title) throws DatabaseException {
        return documentRepository.findByTitle(title);
    }

    public List<Document> getDocumentsByAuthor(String author) throws DatabaseException {
        return documentRepository.findByAuthor(author);
    }

    public List<Document> getDocumentsByYearPublished(int year) throws DatabaseException {
        return documentRepository.findByYearPublished(year);
    }
}
