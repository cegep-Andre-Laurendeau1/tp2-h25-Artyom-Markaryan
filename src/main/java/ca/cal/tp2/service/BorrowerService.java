package ca.cal.tp2.service;

import ca.cal.tp2.modele.BorrowedDocument;
import ca.cal.tp2.modele.Borrower;
import ca.cal.tp2.persistance.BorrowerRepository;
import ca.cal.tp2.persistance.BorrowRepository;
import ca.cal.tp2.persistance.DocumentRepository;
import ca.cal.tp2.exception.DatabaseException;
import java.util.List;
import ca.cal.tp2.modele.Document;
import java.time.LocalDate;
import ca.cal.tp2.modele.Borrow;

public class BorrowerService {
    private final BorrowerRepository borrowerRepository;
    private final BorrowRepository borrowRepository;
    private final DocumentRepository documentRepository;

    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
        this.borrowRepository = new BorrowRepository();
        this.documentRepository = new DocumentRepository();
    }

    public void addBorrower(Borrower borrower) throws DatabaseException {
        borrowerRepository.save(borrower);
    }

    public Borrower getBorrower(int id) throws DatabaseException {
        return borrowerRepository.findById(id);
    }

    public boolean borrowDocuments(Borrower borrower, List<Document> documents) throws DatabaseException {
        LocalDate now = LocalDate.now();
        Borrow borrow = new Borrow(borrower, now, "En attente");
        for (Document document : documents) {
            if (getCopiesAvailable(document) <= 0) return false;
            int borrowDuration = document.getBorrowDuration();
            BorrowedDocument borrowedDocument = new BorrowedDocument(
                borrow, document, now, now.plusWeeks(borrowDuration), null, "En attente"
            );
            borrow.getBorrowedDocumentsList().add(borrowedDocument);
        }
        borrower.getBorrowsList().add(borrow);
        borrowRepository.save(borrow);
        return true;
    }

    private long getCopiesAvailable(Document document) throws DatabaseException {
        return Math.subtractExact(
            documentRepository.countDocumentCopies(document.getId()),
            borrowRepository.countBorrowedCopies(document.getId())
        );
    }

    public List<Borrow> getBorrowsList(Borrower borrower) {
        return borrower.getBorrowsList();
    }
}
