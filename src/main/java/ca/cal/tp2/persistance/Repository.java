package ca.cal.tp2.persistance;

import java.sql.SQLException;

public interface Repository<T> {
    public boolean create(T object) throws SQLException;
    public T read(int id) throws SQLException;
    public boolean update(T object) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
