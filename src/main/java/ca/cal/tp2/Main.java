package ca.cal.tp2;

import java.sql.SQLException;
import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.modele.Book;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibrarianService librarianService = new LibrarianService(new DocumentRepository());
        librarianService.addLibraryDocument(
            new Book(
                "Livre Exemple",
                "Auteur",
                LocalDate.of(2025, 1, 1),
                3,
                "Éditeur",
                100
            )
        );
        librarianService.addLibraryDocument(
            new CD(
                "CD Exemple",
                "Artiste",
                LocalDate.of(2025, 1, 1),
                5,
                240,
                "Acoustique"
            )
        );
        librarianService.addLibraryDocument(
            new DVD(
                "DVD Exemple",
                "Directeur",
                LocalDate.of(2025, 1, 1),
                1,
                7200,
                10
            )
        );
        System.out.println("Liste des documents dans l'inventaire de la bibliothèque:");
        System.out.println(librarianService.getLibraryDocuments());
    }
}
