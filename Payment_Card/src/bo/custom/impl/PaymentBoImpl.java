package bo.custom.impl;

import bo.custom.PaymentBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.PaymentDAO;
import dto.CustomerDto;
import dto.PaymentDTO;
import entity.Customer;
import entity.Payment;

import java.sql.SQLException;

public class PaymentBoImpl implements PaymentBo {
    private PaymentDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENT);
    private QueryDAO qdao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);


    @Override
    public boolean savePayment(PaymentDTO dto) throws Exception {
        return dao.save(new Payment(dto.getPID(),dto.getCID(),dto.getDate(),dto.getTime(),dto.getType(),dto.getPrice()));
    }

    @Override
    public String getID() throws SQLException, ClassNotFoundException {
        return qdao.getPID();
    }

    @Override
    public PaymentDTO getPayment(String pid) throws Exception {
        Payment payment=dao.get(pid);
        return new PaymentDTO(payment.getPID(),payment.getCID(),payment.getDate(),payment.getTime(),payment.getType(),payment.getPrice());
    }
}

