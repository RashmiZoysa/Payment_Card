package bo.custom.impl;

import bo.custom.CardBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.CardCategoryDAO;
import dao.custom.CardDAO;
import dao.custom.PaymentDAO;
import db.DBConnection;
import dto.CardDTO;
import dto.TransportCategoryDTO;
import dto.categoryDTO;
import dto.custom.carddetailDTO;
import entity.Card;
import entity.Payment;
import entity.TransportCategory;
import entity.category;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.SQLException;

public class CardBoImpl implements CardBo {
    private CardDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CARD);
    private CardCategoryDAO dao2 = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CATEGORY);
    private QueryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);
    private PaymentDAO PDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENT);


    @Override
    public boolean saveCard(CardDTO card) throws SQLException, ClassNotFoundException {
        return dao.save(
                new Card(
                        card.getCID(), card.getNic(), card.getTid(), card.getDestination(), card.getCategoryID(), card.getDuration(), card.getExpireDate(), card.getPrice())
        );
    }

    @Override
    public boolean updateCard(CardDTO card) throws SQLException, ClassNotFoundException {
        return dao.update(new Card(card.getCID(), card.getNic(), card.getTid(), card.getDestination(), card.getCategoryID(), card.getDuration(), card.getExpireDate(), card.getPrice()));
    }

    @Override
    public boolean deleteCard(String CId) throws SQLException, ClassNotFoundException {
        return dao.delete(CId);
    }

    @Override
    public CardDTO getCard(String CaID) throws Exception {
        Card card = dao.get(CaID);
        return new CardDTO(card.getCID(), card.getNic(), card.getTid(), card.getDestination(), card.getCategoryID(), card.getDuration(), card.getExpireDate(), card.getPrice());
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return qDao.getID();
    }

    @Override
    public TransportCategoryDTO getTID(String destination) throws SQLException, ClassNotFoundException {
        TransportCategory cat = qDao.getTID(destination);
        return new TransportCategoryDTO(
                cat.getTID(),
                cat.getDestination(),
                cat.getPeoplePrice(),
                cat.getPeopleItemPrice(),
                cat.getItemPrice(),
                cat.getPeoplePetPrice()
        );
    }

    @Override
    public String getCatId(String s) throws SQLException, ClassNotFoundException {
        return qDao.getCatID(s);
    }

    @Override
    public String getTransType(String tid) throws SQLException, ClassNotFoundException {
        return qDao.getTransType(tid);
    }

    @Override
    public String selectCatType(String categoryID) throws SQLException, ClassNotFoundException {
        return qDao.getTransType(categoryID);
    }

    @Override
    public int getCardCount() throws SQLException, ClassNotFoundException {
        return qDao.getCardCount();
    }

    @Override
    public boolean saveDetails(carddetailDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isSaved = dao.save(
                    new Card(
                            dto.getCID(),
                            dto.getNIC(),
                            dto.getTID(),
                            dto.getDestination(),
                            dto.getCategoryID(),
                            dto.getDuration(),
                            dto.getExpireDate(),
                            dto.getPrice()
                    )
            );

        if (!isSaved) {
            connection.rollback();
            return false;
        }


            isSaved = PDao.save(
                    new Payment(
                            dto.getPID(),
                            dto.getCID(),
                            dto.getPaidDate(),
                            dto.getPaidTime(),
                            dto.getPaymentType(),
                            dto.getPrice()
                    )
            );

        if (!isSaved) {
            connection.rollback();
            return false;
        }
        connection.commit();
        return true;
    }catch (Throwable throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public categoryDTO getCatDetails(String s) throws Exception {
        category entity=dao2.get(s);
        return new categoryDTO(
                entity.getCategoryID(),
                entity.getCategoryType(),
                entity.getDescription()
        );
    }

}
