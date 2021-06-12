package dao.custom.impl;

import dao.custom.TransportCategoryDAO;
import entity.TransportCategory;

import java.sql.SQLException;
import java.util.List;

public class TransportCategoryDaoImpl implements TransportCategoryDAO {
    @Override
    public boolean save(TransportCategory transportCategory) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TransportCategory transportCategory) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TransportCategory get(String s) throws Exception {
        return null;
    }

    @Override
    public List<TransportCategory> getAll() throws Exception {
        return null;
    }
}
