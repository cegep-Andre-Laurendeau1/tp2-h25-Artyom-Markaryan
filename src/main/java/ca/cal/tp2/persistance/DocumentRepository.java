package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import java.sql.SQLException;

public class DocumentRepository implements Repository<Document> {
    @Override
    public boolean save(Document document) throws SQLException {
        return false;
    }

    @Override
    public Document findById(int id) throws SQLException {
        return null;
    }
}
