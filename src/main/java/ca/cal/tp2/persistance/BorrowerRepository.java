package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Borrower;
import ca.cal.tp2.exception.DatabaseException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BorrowerRepository implements Repository<Borrower> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.pu");

    @Override
    public void save(Borrower borrower) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(borrower);
            em.getTransaction().commit();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Borrower findById(int id) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Borrower> query = em.createQuery(
                "SELECT b FROM Borrower b WHERE b.id = :id", Borrower.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
