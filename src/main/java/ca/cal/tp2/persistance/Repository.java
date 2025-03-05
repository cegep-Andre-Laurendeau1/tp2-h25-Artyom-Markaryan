package ca.cal.tp2.persistance;

import java.sql.SQLException;

public interface Repository<T> {
    boolean save(T document) throws SQLException;
    T findById(int id) throws SQLException;
}
