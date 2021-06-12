package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.CardCategoryDAO;
import entity.category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CardCategoryDaoImpl implements CardCategoryDAO {
    @Override
    public boolean save(category cardCategory) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(category cardCategory) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public category get(String s) throws Exception {
        ResultSet rst= CrudUtill.execute("SELECT * FROM category WHERE categoryID=?",s);
        if(rst.next()){
            return new category(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }

    @Override
    public List<category> getAll() throws Exception {
        return null;
    }
}
