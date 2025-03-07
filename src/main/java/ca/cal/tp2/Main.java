package ca.cal.tp2;

import java.sql.SQLException;
import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.service.BorrowerService;
import ca.cal.tp2.modele.*;
import java.time.LocalDate;
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
            System.out.println(librarianService.getDocumentById(1));
            librarianService.addDocument(
                new CD("CD Exemple", "Artiste", LocalDate.of(2025, 1, 1), 240, "Acoustique")
            );
            System.out.println(librarianService.getDocumentById(2));
            librarianService.addDocument(
                new DVD("DVD Exemple", "Directeur", LocalDate.of(2025, 1, 1), 7200, 10)
            );
            System.out.println(librarianService.getDocumentById(3));
            borrowerService.addBorrower(
                new Borrower("Emprunteur", "Exemple", "courriel@exemple.com", "000-000-0000")
            );
            System.out.println(borrowerService.getBorrower(2));
        }
        catch (DatabaseException e) {
            System.out.println("Erreur avec la base de données: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
