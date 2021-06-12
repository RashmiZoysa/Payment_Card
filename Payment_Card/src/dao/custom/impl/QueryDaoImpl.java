package dao.custom.impl;

import dao.CrudUtill;
import dao.QueryDAO;
import dto.TransportCategoryDTO;
import entity.TransportCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDaoImpl implements QueryDAO {

    @Override
    public String getNic() {
        return null;
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT CID FROM card ORDER BY CID DESC LIMIT 1");
        String id = "C001";
        if (rst.next()) {
            String temp = rst.getString(1);
            String[] cs = temp.split("C");
            int selectedID = Integer.parseInt(cs[1]);
            if (selectedID < 10) {
                id = "C00" + (selectedID + 1);
            } else if (selectedID < 100) {
                id = "C0" + (selectedID + 1);
            }
        }
        return id;
    }

    @Override
    public TransportCategory getTID(String destination) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * FROM transportcategory WHERE destination=?", destination);
        if (rst.next()) {
            return new TransportCategory(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6)
            );
        }
        return null;
    }

    @Override
    public String getCatID(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT categoryID from category where categoryType=?", s);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public String getTransType(String tid) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getPID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT PID FROM payment ORDER BY PID DESC LIMIT 1");
        String id = "P001";
        if (rst.next()) {
            String temp = rst.getString(1);
            String[] cs = temp.split("P");
            int selectedID = Integer.parseInt(cs[1]);
            if (selectedID < 10) {
                id = "P00" + (selectedID + 1);
            } else if (selectedID < 100) {
                id = "P0" + (selectedID + 1);
            }
        }
        return id;
    }

    @Override
    public int getCardCount() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * from card");
        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count;
    }


    public int getCustomerCount() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * from customer");
        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count;
    }

    @Override
    public int getDriverCount() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * from DRIVER");
        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count;
    }

    @Override
    public String getdid() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT DID FROM DRIVER ORDER BY DID DESC LIMIT 1");
        String did = "D001";
        if (rst.next()) {
            String temp = rst.getString(1);
            String[] cs = temp.split("D");
            int selectedID = Integer.parseInt(cs[1]);
            if (selectedID < 10) {
                did = "D00" + (selectedID + 1);
            } else if (selectedID < 100) {
                did = "D0" + (selectedID + 1);
            }
        }
        return did;
    }

    @Override
    public int getBusCount() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT * from BUS");
        int count = 0;
        while (rst.next()) {
            count++;
        }
        return count;
    }

    @Override
    public String getbid() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.execute("SELECT BID FROM BUS ORDER BY BID DESC LIMIT 1");
        String bid = "B001";
        if (rst.next()) {
            String temp = rst.getString(1);
            String[] cs = temp.split("B");
            int selectedID = Integer.parseInt(cs[1]);
            if (selectedID < 10) {
                bid = "B00" + (selectedID + 1);
            } else if (selectedID < 100) {
                bid = "B0" + (selectedID + 1);
            }
        }
        return bid;
    }

    @Override
    public ArrayList<String> getDID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtill.execute("SELECT DID FROM Driver");
        ArrayList<String> did = new ArrayList<>();
        while (resultSet.next()) {
            did.add(resultSet.getString(1)
            );
        }
        return did;
    }

    @Override
    public ArrayList<String> getBID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtill.execute("SELECT BID FROM BUS");
        ArrayList<String> bid = new ArrayList<>();
        while (resultSet.next()) {
            bid.add(resultSet.getString(1)
            );
        }
        return bid;    }

}