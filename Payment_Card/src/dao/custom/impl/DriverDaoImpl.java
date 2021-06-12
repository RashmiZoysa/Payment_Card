package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.DriverDao;
import entity.Customer;
import entity.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl implements DriverDao {
    @Override
    public boolean save(Driver driver) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO DRIVER VALUES (?,?,?,?,?,?)",driver.getDID(),driver.getName(),driver.getNIC(),driver.getDOB(),driver.getAddress(),driver.getContactNo());
    }

    @Override
    public boolean update(Driver driver) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Driver get(String did) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * FROM DRIVER WHERE DID=?",did);
        if (rst.next()){
            return new Driver(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public List<Driver> getAll() throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM DRIVER");
        ArrayList<Driver>arrayList=new ArrayList<>();
        while(rst.next()){
            arrayList.add(new Driver(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)));
        }
        return arrayList;
    }
}
