package ca.cal.tp2.service;

import ca.cal.tp2.persistance.Repository;
import ca.cal.tp2.modele.Librarian;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.persistance.LibrarianRepository;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.exception.DatabaseException;

public class LibrarianService {
    private final Repository<Librarian> librarianRepository;
    private final Repository<Document> documentRepository;

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
}
