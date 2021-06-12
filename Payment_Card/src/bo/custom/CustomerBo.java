package bo.custom;

import dto.CustomerDto;

import java.sql.SQLException;

public interface CustomerBo {
    public boolean SaveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    public boolean UpdateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    public boolean DeleteCustomer(String Nic) throws SQLException, ClassNotFoundException;

    public CustomerDto getCustomer(String cid) throws Exception;

    public int getcustomerCount() throws SQLException, ClassNotFoundException;
}
