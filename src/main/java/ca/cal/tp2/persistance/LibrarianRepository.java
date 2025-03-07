package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Librarian;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ca.cal.tp2.exception.DatabaseException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LibrarianRepository implements Repository<Librarian> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.pu");

    @Override
    public void save(Librarian librarian) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(librarian);
            em.getTransaction().commit();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Librarian findById(int id) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Librarian> query = em.createQuery(
                "SELECT l FROM Librarian l WHERE l.id = :id", Librarian.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
