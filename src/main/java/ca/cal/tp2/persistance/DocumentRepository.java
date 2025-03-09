package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import ca.cal.tp2.exception.DatabaseException;
import jakarta.persistence.TypedQuery;
import java.util.List;

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

    public List<Document> findByTitle(String title) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Document> query = em.createQuery(
                "SELECT d FROM Document d WHERE LOWER(d.title) LIKE LOWER(:title)", Document.class
            );
            query.setParameter("title", "%" + title + "%");
            return query.getResultList();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Document> findByAuthor(String author) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Document> query = em.createQuery(
                    "SELECT d FROM Document d WHERE LOWER(d.author) = LOWER(:author)", Document.class
            );
            query.setParameter("author", author);
            return query.getResultList();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Document> findByYearPublished(int year) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Document> query = em.createQuery(
                    "SELECT d FROM Document d WHERE YEAR(d.datePublished) = :year", Document.class
            );
            query.setParameter("year", year);
            return query.getResultList();
        }
        catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
