package dao.custom;

import dao.CrudDAO;
import entity.Bus;

import java.util.ArrayList;

public interface BusDao extends CrudDAO<Bus,String> {
    public ArrayList<String> getId() throws Exception;
}
