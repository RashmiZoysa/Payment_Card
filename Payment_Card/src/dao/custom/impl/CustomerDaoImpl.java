package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtill;
import dao.custom.CustomerDAO;
import entity.Customer;
import entity.SuperEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)",customer.getNic(),customer.getCustomerName(),customer.getDob(),customer.getAddress(),customer.getContactNo(),customer.getEmail());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("UPDATE CUSTOMER SET CustomerName=?,DOB=?,CustomerAddress =?,ContactNo=?,Email=? WHERE NIC=? ",customer.getCustomerName(),customer.getDob(),customer.getAddress(),customer.getContactNo(),customer.getEmail(),customer.getNic());
    }

    @Override
    public boolean delete(String nic) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("DELETE from CUSTOMER WHERE NIC=?",nic);
    }

    @Override
    public Customer get(String s) throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM CUSTOMER WHERE NIC=?",s);
        if(rst.next()){
            return new Customer(rst.getString(1),
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
    public List getAll() throws Exception {
        return null;
    }
}
