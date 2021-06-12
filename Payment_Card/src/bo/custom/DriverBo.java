package bo.custom;

import dto.CustomerDto;
import dto.DriverDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DriverBo {
    public boolean SaveDriver(DriverDTO dto) throws SQLException, ClassNotFoundException;

    public DriverDTO getDriver(String did) throws Exception;

    public int getDriverCount() throws SQLException, ClassNotFoundException;

    String getdid()  throws SQLException, ClassNotFoundException;

    public ArrayList<DriverDTO> getAllDrivers()throws Exception;

    public boolean deleteDriver(String did) throws Exception;

    public ArrayList<String> getDID() throws SQLException, ClassNotFoundException;
}
