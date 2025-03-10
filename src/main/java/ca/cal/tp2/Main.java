package ca.cal.tp2;

import java.sql.SQLException;
import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.service.BorrowerService;
import ca.cal.tp2.modele.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import ca.cal.tp2.modele.Borrow;
import ca.cal.tp2.exception.DatabaseException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        LibrarianService librarianService = new LibrarianService();
        BorrowerService borrowerService = new BorrowerService();
        try {
            System.out.println("Ajout d'un utilisateur Bibliothécaire...");
            librarianService.addLibrarian(
                new Librarian("Bibliothécaire", "Exemple", "courriel@exemple.com", "000-000-0000")
            );
            System.out.println(librarianService.getLibrarian(1) + "\n");

            System.out.println("Ajout des documents dans la bibliothèque...");
            librarianService.addDocument(
                new Book("Livre Exemple", "Auteur", LocalDate.of(2025, 1, 1), "Éditeur", 100)
            );
            librarianService.addDocument(
                new CD("CD Exemple", "Artiste", LocalDate.of(2025, 1, 1), 240, "Acoustique")
            );
            librarianService.addDocument(
                new DVD("DVD Exemple", "Directeur", LocalDate.of(2025, 1, 1), 7200, 10)
            );

            int queryYear = 2025;
            System.out.println("\nVoici tous les documents publiés en " + queryYear + ":");
            for (Document document : librarianService.getDocumentsByYearPublished(queryYear)) {
                System.out.println(document);
            }

            String queryTitle = "Livre";
            System.out.println("\nVoici tous les documents dont le titre contient \"" + queryTitle + "\":");
            for (Document document : librarianService.getDocumentsByTitle(queryTitle)) {
                System.out.println(document);
            }

            String queryAuthor = "Artiste";
            System.out.println("\nVoici tous les documents publiés par \"" + queryAuthor + "\":");
            for (Document document : librarianService.getDocumentsByAuthor(queryAuthor)) {
                System.out.println(document);
            }

            System.out.println("\nAjout d'un utilisateur Emprunteur...");
            Borrower exampleBorrower = new Borrower(
                "Emprunteur", "Exemple", "courriel@exemple.com", "000-000-0000"
            );
            borrowerService.addBorrower(exampleBorrower);
            System.out.println(borrowerService.getBorrower(2));

            Document document1 = librarianService.getDocumentById(1);
            List<Document> wishlist = new ArrayList<>();
            wishlist.add(document1);
            System.out.println("\nOn veut emprunteur les documents suivants:");
            for (Document document : wishlist) {
                System.out.println(document);
            }
            System.out.println("On tente d'emprunter ces documents...");
            System.out.println(
                borrowerService.borrowDocuments(exampleBorrower, wishlist) ? "Emprunt approuvé" : "Emprunt refusé"
            );
            System.out.println("On tente d'emprunter ces documents encore...");
            System.out.println(
                borrowerService.borrowDocuments(exampleBorrower, wishlist) ? "Emprunt approuvé" : "Emprunt refusé"
            );
            System.out.println("(Un emprunt peut être refusé s'il n'y a pas d'exemplaire d'un document disponible)");

            System.out.println("\nVoici la liste des emprunts approuvés qu'on vient de faire:");
            for (Borrow borrow : borrowerService.getBorrowsList(exampleBorrower)) {
                System.out.println(borrow);
            }
        }
        catch (DatabaseException e) {
            System.err.println("Erreur au niveau de la base de données: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
