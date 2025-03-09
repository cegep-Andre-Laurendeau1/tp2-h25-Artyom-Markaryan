package ca.cal.tp2.service;

import ca.cal.tp2.modele.BorrowedDocument;
import ca.cal.tp2.modele.Borrower;
import ca.cal.tp2.persistance.BorrowerRepository;
import ca.cal.tp2.persistance.BorrowRepository;
import ca.cal.tp2.exception.DatabaseException;
import java.util.List;
import ca.cal.tp2.modele.Document;
import java.time.LocalDate;
import ca.cal.tp2.modele.Borrow;

public class BorrowerService {
    private final BorrowerRepository borrowerRepository;
    private final BorrowRepository borrowRepository;

    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
        this.borrowRepository = new BorrowRepository();
    }

    public void addBorrower(Borrower borrower) throws DatabaseException {
        borrowerRepository.save(borrower);
    }

    public Borrower getBorrower(int id) throws DatabaseException {
        return borrowerRepository.findById(id);
    }

    public void borrowDocuments(List<Document> documents) throws DatabaseException {
        LocalDate now = LocalDate.now();
        Borrower borrower = borrowerRepository.findById(2);
        Borrow borrow = new Borrow(borrower, now, "En attente");
        for (Document document : documents) {
            int borrowDuration = document.getBorrowDuration();
            BorrowedDocument borrowedDocument = new BorrowedDocument(
                borrow, document, now, now.plusWeeks(borrowDuration), null, "En attente"
            );
            borrow.getBorrowedDocumentsList().add(borrowedDocument);
        }
        borrowRepository.save(borrow);
        // TODO: Vérifier s'il y a des exemplaires disponibles pour cet emprunt
    }
}
