package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T get(long id);

    List<T> getAll();

    Long save(T t);

    void update(T t, String[] params);

    void delete(long id) throws SQLException;
}
