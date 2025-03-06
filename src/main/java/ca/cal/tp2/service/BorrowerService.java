package ca.cal.tp2.service;

import ca.cal.tp2.persistance.Repository;
import ca.cal.tp2.modele.Borrower;
import ca.cal.tp2.persistance.BorrowerRepository;
import ca.cal.tp2.exception.DatabaseException;

public class BorrowerService {
    private final Repository<Borrower> borrowerRepository;

    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
    }

    public void addBorrower(Borrower borrower) throws DatabaseException {
        borrowerRepository.save(borrower);
    }

    public Borrower getBorrower(int id) throws DatabaseException {
        return borrowerRepository.findById(id);
    }
}
