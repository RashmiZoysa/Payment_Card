package bo.custom;

import dto.CardDTO;
import dto.TransportCategoryDTO;
import dto.categoryDTO;
import dto.custom.carddetailDTO;

import java.sql.SQLException;

public interface CardBo{
    public boolean saveCard(CardDTO card) throws SQLException, ClassNotFoundException;

    public boolean updateCard(CardDTO card) throws SQLException, ClassNotFoundException;

    public boolean deleteCard(String CID) throws SQLException, ClassNotFoundException;

    public CardDTO getCard(String CID) throws Exception;

    public String getID() throws SQLException, ClassNotFoundException;

    public TransportCategoryDTO getTID(String destination) throws SQLException, ClassNotFoundException;

    public String getCatId(String s) throws SQLException, ClassNotFoundException;

    public String getTransType(String tid) throws SQLException, ClassNotFoundException;

    public String selectCatType(String categoryID) throws SQLException, ClassNotFoundException;

    public int getCardCount() throws SQLException, ClassNotFoundException;

    public boolean saveDetails(carddetailDTO dto) throws SQLException, ClassNotFoundException;

    public categoryDTO getCatDetails(String s) throws Exception;
}
