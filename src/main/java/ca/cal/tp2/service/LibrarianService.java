package ca.cal.tp2.service;

import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.modele.Document;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class LibrarianService {
    private final DocumentRepository documentRepository;

    public LibrarianService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void addLibraryDocument(Document document) throws SQLException {
        if (documentRepository.create(document)) {
            System.out.println("Document " + document.getTitle() + " ajouté avec succès");
        }
    }

    public List<Document> getLibraryDocuments() throws SQLException {
        List<Document> libraryDocuments = new ArrayList<>();
        int i = 1;
        while (documentRepository.read(i) != null) {
            libraryDocuments.add(documentRepository.read(i));
            i++;
        }
        return libraryDocuments;
    }
}
