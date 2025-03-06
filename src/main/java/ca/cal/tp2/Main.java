package ca.cal.tp2;

import ca.cal.tp2.exception.DatabaseException;
import ca.cal.tp2.service.LibrarianService;
import ca.cal.tp2.modele.Book;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import java.time.LocalDate;
import ca.cal.tp2.service.BorrowerService;
import ca.cal.tp2.modele.Borrower;

public class Main {
    public static void main(String[] args) throws DatabaseException, InterruptedException {
//        LibrarianService librarianService = new LibrarianService();
//        librarianService.addLibraryDocument(
//            new Book(
//                "Livre Exemple",
//                "Auteur",
//                LocalDate.of(2025, 1, 1),
//                "Éditeur",
//                100
//            )
//        );
//        librarianService.addLibraryDocument(
//            new CD(
//                "CD Exemple",
//                "Artiste",
//                LocalDate.of(2025, 1, 1),
//                240,
//                "Acoustique"
//            )
//        );
//        librarianService.addLibraryDocument(
//            new DVD(
//                "DVD Exemple",
//                "Directeur",
//                LocalDate.of(2025, 1, 1),
//                7200,
//                10
//            )
//        );
        BorrowerService borrowerService = new BorrowerService();
        try {
            borrowerService.addBorrower(
                    new Borrower(
                            "Emprunteur",
                            "Exemple",
                            "courriel@exemple.com",
                            "000-000-0000"
                    )
            );
        }
        catch (DatabaseException e) {
            System.out.println("Erreur avec la base de données: " + e.getMessage());
        }
        try {
            System.out.println(borrowerService.getBorrower(1));
        }
        catch (DatabaseException e) {
            System.out.println("Erreur avec la base de données: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
