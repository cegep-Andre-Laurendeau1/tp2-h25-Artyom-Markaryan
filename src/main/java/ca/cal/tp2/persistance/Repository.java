package ca.cal.tp2.persistance;

import ca.cal.tp2.exception.DatabaseException;

public interface Repository<T> {
    void save(T document) throws DatabaseException;
    T findById(int id) throws DatabaseException;
}
