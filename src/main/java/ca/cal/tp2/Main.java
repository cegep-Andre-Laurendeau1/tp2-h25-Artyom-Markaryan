package ca.cal.tp2;

import java.sql.SQLException;
import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.service.BorrowerService;
import ca.cal.tp2.modele.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import ca.cal.tp2.exception.DatabaseException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        LibrarianService librarianService = new LibrarianService();
        BorrowerService borrowerService = new BorrowerService();
        try {
            librarianService.addLibrarian(
                new Librarian("Bibliothécaire", "Exemple", "courriel@exemple.com", "000-000-0000")
            );
            System.out.println(librarianService.getLibrarian(1));

            librarianService.addDocument(
                new Book("Livre Exemple", "Auteur", LocalDate.of(2025, 1, 1), "Éditeur", 100)
            );
            librarianService.addDocument(
                new CD("CD Exemple", "Artiste", LocalDate.of(2025, 1, 1), 240, "Acoustique")
            );
            librarianService.addDocument(
                new DVD("DVD Exemple", "Directeur", LocalDate.of(2025, 1, 1), 7200, 10)
            );
            System.out.println(librarianService.getDocumentsByYearPublished(2025));
            System.out.println(librarianService.getDocumentsByTitle("Livre"));
            System.out.println(librarianService.getDocumentsByAuthor("Artiste"));

            Borrower exampleBorrower = new Borrower(
                "Emprunteur", "Exemple", "courriel@exemple.com", "000-000-0000"
            );
            borrowerService.addBorrower(exampleBorrower);
            System.out.println(borrowerService.getBorrower(2));

            List<Document> wishlist = new ArrayList<>();
            wishlist.add(librarianService.getDocumentById(1));
            System.out.println("Emprunt approuvé: " +
                borrowerService.borrowDocuments(exampleBorrower, wishlist)
            );
            System.out.println("Emprunt approuvé: " +
                borrowerService.borrowDocuments(exampleBorrower, wishlist)
            );
        }
        catch (DatabaseException e) {
            System.err.println("Erreur au niveau de la base de données: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
