package ca.cal.tp2;

import java.sql.SQLException;
import ca.cal.tp2.modele.Librarian;
import ca.cal.tp2.modele.Book;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Librarian librarian = new Librarian("Bibliothécaire", "Exemple", "courriel@gmail.com", "000 000 0000");
        librarian.addNewDocument(
            new Book(
                "Livre Exemple",
                "Auteur",
                LocalDate.of(2025, 1, 1),
                "Book",
                3,
                "Éditeur",
                100
            )
        );
        librarian.addNewDocument(
            new CD(
                "CD Exemple",
                "Artiste",
                LocalDate.of(2025, 1, 1),
                "CD",
                5,
                240,
                "Acoustique"
            )
        );
        librarian.addNewDocument(
            new DVD(
                "DVD Exemple",
                "Directeur",
                LocalDate.of(2025, 1, 1),
                "DVD",
                1,
                7200,
                10
            )
        );
        System.out.println("Liste des documents dans l'inventaire de la bibliothèque:");
        System.out.println(librarian.viewLibraryDocuments());
    }
}
