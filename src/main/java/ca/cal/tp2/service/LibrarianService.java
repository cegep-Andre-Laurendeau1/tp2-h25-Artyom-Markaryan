package ca.cal.tp2.service;

import ca.cal.tp2.persistance.Repository;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.exception.DatabaseException;

public class LibrarianService {
    private final Repository<Document> documentRepository;

    public LibrarianService() {
        this.documentRepository = new DocumentRepository();
    }

    public void addLibraryDocument(Document document) throws DatabaseException {
        documentRepository.save(document);
    }
}
