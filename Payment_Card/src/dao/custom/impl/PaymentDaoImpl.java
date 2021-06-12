package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.PaymentDAO;
import entity.Customer;
import entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaymentDaoImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO PAYMENT VALUES(?,?,?,?,?,?)",payment.getPID(),payment.getCID(),payment.getDate(),payment.getTime(),payment.getType(),payment.getPrice());
    }

    @Override
    public boolean update(Payment payment) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment get(String cid) throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM PAYMENT WHERE CID=?",cid);
        if(rst.next()){
            return new Payment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6)
            );
        }
        return null;
    }

    @Override
    public List<Payment> getAll() throws Exception {
        return null;
    }
}
