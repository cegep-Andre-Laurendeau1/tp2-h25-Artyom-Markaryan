package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Book;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import ca.cal.tp1.utils.JDBCConnectionPool;

public class DocumentRepository implements Repository<Document> {
    @Override
    public boolean create(Document document) throws SQLException {
        String query =
                "INSERT INTO document " +
                "(doc_title, doc_author, doc_type, doc_date_published, doc_copies, doc_editor, doc_pages, doc_duration, doc_genre, doc_rating) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
             Connection connection = JDBCConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
            preparedStatement.setString(1, document.getTitle());
            preparedStatement.setString(2, document.getAuthor());
            String documentType = document.getDocumentType();
            preparedStatement.setString(3, documentType);
            preparedStatement.setDate(4, Date.valueOf(document.getDatePublished()));
            preparedStatement.setInt(5, document.getCopies());
            switch (documentType) {
                case "Book":
                    preparedStatement.setString(6, ((Book) document).getEditor());
                    preparedStatement.setInt(7, ((Book) document).getPages());
                    break;
                case "CD":
                    preparedStatement.setInt(8, ((CD) document).getDuration());
                    preparedStatement.setString(9, ((CD) document).getGenre());
                    break;
                case "DVD":
                    preparedStatement.setInt(8, ((DVD) document).getDuration());
                    preparedStatement.setInt(10, ((DVD) document).getRating());
                    break;
            }
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Document read(int id) throws SQLException {
        String query = "SELECT * FROM document WHERE doc_id = ?";
        try (
                Connection connection = JDBCConnectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Document foundDocument = null;
            if (resultSet.next()) {
                String documentType = resultSet.getString("doc_type");
                switch (documentType) {
                    case "Book":
                        foundDocument = new Book(
                            resultSet.getString("doc_title"),
                            resultSet.getString("doc_author"),
                            resultSet.getDate("doc_date_published").toLocalDate(),
                            documentType,
                            resultSet.getInt("doc_copies"),
                            resultSet.getString("doc_editor"),
                            resultSet.getInt("doc_pages")
                        );
                        break;
                    case "CD":
                        foundDocument = new CD(
                            resultSet.getString("doc_title"),
                            resultSet.getString("doc_author"),
                            resultSet.getDate("doc_date_published").toLocalDate(),
                            documentType,
                            resultSet.getInt("doc_copies"),
                            resultSet.getInt("doc_duration"),
                            resultSet.getString("doc_genre")
                        );
                        break;
                    case "DVD":
                        foundDocument = new DVD(
                            resultSet.getString("doc_title"),
                            resultSet.getString("doc_author"),
                            resultSet.getDate("doc_date_published").toLocalDate(),
                            documentType,
                            resultSet.getInt("doc_copies"),
                            resultSet.getInt("doc_duration"),
                            resultSet.getInt("doc_rating")
                        );
                        break;
                }
            }
            return foundDocument;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(Document document) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
