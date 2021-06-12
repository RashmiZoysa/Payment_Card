package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.CustomerDAO;
import dto.CustomerDto;
import entity.Customer;


import javax.naming.NoInitialContextException;
import java.sql.SQLException;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDAO dao=DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    private QueryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean SaveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return dao.save(new Customer(dto.getNic(),dto.getCustomerName(),dto.getDob(),dto.getAddress(),dto.getContactNo(),dto.getEmail()));
    }

    @Override
    public boolean UpdateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return dao.update(new Customer(dto.getNic(),dto.getCustomerName(),dto.getDob(),dto.getAddress(),dto.getContactNo(),dto.getEmail()));
    }

    @Override
    public boolean DeleteCustomer(String Nic) throws SQLException, ClassNotFoundException {
        return dao.delete(Nic);
    }

    @Override
    public CustomerDto getCustomer(String nic) throws Exception {
        Customer customer=dao.get(nic);
        return new CustomerDto(customer.getNic(),customer.getCustomerName(),customer.getDob(),customer.getAddress(),customer.getContactNo(),customer.getEmail());
    }


    @Override
    public int getcustomerCount() throws SQLException, ClassNotFoundException {
        return qDao.getCustomerCount();
    }
}
