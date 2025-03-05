package ca.cal.tp2.modele;

import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.persistance.DocumentRepository;
import java.sql.SQLException;
import java.util.List;

public class Librarian extends User {
    private final LibrarianService librarianService;

    public Librarian(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
        this.librarianService = new LibrarianService(new DocumentRepository());
    }

    public void addNewDocument(Document document) throws SQLException {
        librarianService.addLibraryDocument(document);
    }

    public List<Document> viewLibraryDocuments() throws SQLException {
        return librarianService.getLibraryDocuments();
    }
}
