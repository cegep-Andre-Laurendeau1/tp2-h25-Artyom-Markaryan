package ca.cal.tp2.service;

import ca.cal.tp2.persistance.Repository;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.modele.Document;
import java.sql.SQLException;

public class LibrarianService {
    private final Repository<Document> documentRepository;

    public LibrarianService() {
        this.documentRepository = new DocumentRepository();
    }

    public void addLibraryDocument(Document document) throws SQLException {
        if (documentRepository.save(document)) {
            System.out.println("Document " + document.getTitle() + " ajouté avec succès");
        }
    }
}
