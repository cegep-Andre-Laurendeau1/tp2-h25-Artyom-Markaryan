package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import ca.cal.tp2.exception.DatabaseException;
import jakarta.persistence.TypedQuery;

public class DocumentRepository implements Repository<Document> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.pu");

    @Override
    public void save(Document document) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(document);
            em.getTransaction().commit();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Document findById(int id) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Document> query = em.createQuery(
                "SELECT d FROM Document d WHERE d.id = :id", Document.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
