package bo.custom;

import dto.BusDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BusBo {
    public boolean SaveBus(BusDTO dto) throws SQLException, ClassNotFoundException;

    public BusDTO getBus(String bid) throws Exception;

    public int getBusCount() throws SQLException, ClassNotFoundException;

    String getBID()  throws SQLException, ClassNotFoundException;

    public boolean deleteBus(String bid) throws Exception;

    public ArrayList<String> getbid() throws Exception;

    public ArrayList<BusDTO> loadAllDetail() throws Exception;
}
