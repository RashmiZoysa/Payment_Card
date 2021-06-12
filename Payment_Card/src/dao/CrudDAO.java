package dao;

import entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T extends SuperEntity, ID> extends SuperDAO {
        public boolean save (T t) throws SQLException, ClassNotFoundException;

        public boolean update (T t) throws SQLException, ClassNotFoundException;

        public boolean delete (ID id) throws SQLException, ClassNotFoundException;

        public T get(ID id) throws Exception;

        public List<T> getAll() throws Exception;
}
