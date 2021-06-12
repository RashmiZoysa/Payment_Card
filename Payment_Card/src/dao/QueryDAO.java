package dao;

import dto.TransportCategoryDTO;
import entity.TransportCategory;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO{
    public String getNic();

    public String getID() throws SQLException, ClassNotFoundException;

    public TransportCategory getTID(String destination) throws SQLException, ClassNotFoundException;

    public String getCatID(String s) throws SQLException, ClassNotFoundException;

    public String getTransType(String tid) throws SQLException, ClassNotFoundException;

    public String getPID() throws SQLException, ClassNotFoundException;

    public int getCardCount() throws SQLException, ClassNotFoundException;

    public int getCustomerCount() throws SQLException, ClassNotFoundException;

    public int getDriverCount() throws SQLException, ClassNotFoundException;

    public String getdid() throws SQLException, ClassNotFoundException;

    public int getBusCount() throws SQLException, ClassNotFoundException;

    public String getbid() throws SQLException, ClassNotFoundException;

    public ArrayList<String> getDID() throws SQLException, ClassNotFoundException;

    public ArrayList<String> getBID() throws SQLException, ClassNotFoundException;


}
