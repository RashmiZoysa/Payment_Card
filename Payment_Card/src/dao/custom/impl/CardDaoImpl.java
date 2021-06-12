package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.CardDAO;
import entity.Card;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CardDaoImpl implements CardDAO{

    @Override
    public boolean save(Card card) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO CARD VALUES (?,?,?,?,?,?,?,?)",card.getCID(),card.getNic(),card.getTid(),card.getDestination(),card.getCategoryID(),card.getDuration(),card.getExpireDate(),card.getPrice());
    }

    @Override
    public boolean update(Card card) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("UPDATE CARD SET NIC=? , TID=? , destination=? , categoryID=? , duration=? , expireDate=? , price=? WHERE CID=?",card.getNic(),card.getTid(),card.getDestination(),card.getCategoryID(),card.getDuration(),card.getExpireDate(),card.getPrice(),card.getCID());

    }

    @Override
    public boolean delete(String CId) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("DELETE FROM CARD WHERE CID=?",CId);
    }

    @Override
    public Card get(String CID) throws Exception {
        ResultSet rst=CrudUtill.execute("SELECT * FROM CARD WHERE CID=?",CID);
        if(rst.next()){
            return new Card(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getDouble(8)
            );
        }
        return null;
    }


    @Override
    public List<Card> getAll() throws Exception {
        return null;
    }
}
