package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.BusDao;
import entity.Bus;
import entity.Driver;
import javafx.collections.FXCollections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDaoImpl implements BusDao {

    @Override
    public boolean save(Bus bus) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO BUS VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                bus.getBID(), bus.getNo(), bus.getName(),bus.getRoute(),
                bus.getDate(), bus.getFacilities(), bus.getType(), bus.getOwnerName()
                , bus.getOwnerNIC(), bus.getOwnerAddress(), bus.getOwnerContactNo());
    }

    @Override
    public boolean update(Bus bus) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Bus get(String bid) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * FROM BUS WHERE BID=?", bid);
        if (rst.next()) {
            return new Bus(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)

            );
        }
        return null;
    }


    @Override
    public List<Bus> getAll() throws Exception {
        ResultSet set = CrudUtill.execute("SELECT * FROM BUS");
        List<Bus> busList = FXCollections.observableArrayList();
        while(set.next()){
            busList.add(new Bus(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11)

            ));
        }
        return busList;
    }

    @Override
    public ArrayList<String> getId() throws Exception {
        ResultSet set = CrudUtill.execute("SELECT BID FROM BUS");
        ArrayList<String> list = new ArrayList<>();
        while (set.next()){
            list.add(set.getString(1));
        }
        return list;
    }
}
