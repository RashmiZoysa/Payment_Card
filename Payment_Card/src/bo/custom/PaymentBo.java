package bo.custom;

import dto.CustomerDto;
import dto.PaymentDTO;

import java.sql.SQLException;

public interface PaymentBo {
    public boolean savePayment(PaymentDTO dto) throws Exception;

    public String getID() throws SQLException, ClassNotFoundException;

    public PaymentDTO getPayment(String pid) throws Exception;

}
