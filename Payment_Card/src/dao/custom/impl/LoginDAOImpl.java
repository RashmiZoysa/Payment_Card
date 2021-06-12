package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.LoginDAO;
import entity.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {


    @Override
    public boolean save(Login login) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Login login) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Login get(String s) throws Exception {
        ResultSet rst= CrudUtill.execute("SELECT * FROM USER WHERE UserName=?",s);
        if(rst.next()){
            return (new Login(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));
        }
        return null;
    }

    @Override
    public List<Login> getAll() throws Exception {
        return null;
    }
}
