package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Borrow;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ca.cal.tp2.exception.DatabaseException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BorrowRepository implements Repository<Borrow> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.pu");

    @Override
    public void save(Borrow borrow) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(borrow);
            em.getTransaction().commit();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Borrow findById(int id) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Borrow> query = em.createQuery(
                "SELECT b FROM Borrow b WHERE b.id = :id", Borrow.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public long countBorrowedCopies(long documentId) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(b) FROM BorrowedDocument b WHERE b.document.id = :documentId", Long.class
            );
            query.setParameter("documentId", documentId);
            return query.getSingleResult();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
