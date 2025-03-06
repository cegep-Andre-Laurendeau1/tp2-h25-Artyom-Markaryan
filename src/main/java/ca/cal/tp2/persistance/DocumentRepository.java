package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.exception.DatabaseException;

public class DocumentRepository implements Repository<Document> {
    @Override
    public void save(Document document) throws DatabaseException {

    }

    @Override
    public Document findById(int id) throws DatabaseException {
        return null;
    }
}
