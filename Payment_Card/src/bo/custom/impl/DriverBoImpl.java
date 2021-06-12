package bo.custom.impl;

import bo.custom.DriverBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.BusDao;
import dao.custom.CustomerDAO;
import dao.custom.DriverDao;
import dto.DriverDTO;
import entity.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverBoImpl implements DriverBo {
    private DriverDao dao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.DRIVER);
    private QueryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean SaveDriver(DriverDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(new Driver(dto.getDID(),dto.getName(),dto.getNIC(),dto.getDOB(),dto.getAddress(),dto.getContactNo()));
    }

    @Override
    public DriverDTO getDriver(String did) throws Exception {
        Driver driver =dao.get(did);
        return new DriverDTO(driver.getDID(),driver.getName(),driver.getNIC(),driver.getDOB(),driver.getAddress(),driver.getContactNo());

    }

    @Override
    public int getDriverCount() throws SQLException, ClassNotFoundException {
        return qDao.getDriverCount();
    }

    @Override
    public String getdid() throws SQLException, ClassNotFoundException {
        return qDao.getdid();

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() throws Exception {
        List<Driver> cList=dao.getAll();
        ArrayList<DriverDTO> dtoList= new ArrayList();
        for (Driver c : cList) {
            dtoList.add(new DriverDTO(c.getDID(),c.getName(),c.getNIC(),c.getDOB(),c.getAddress(),c.getContactNo()));
        }
        return dtoList;
    }

    @Override
    public boolean deleteDriver(String did) throws Exception {
        return dao.delete(did);
    }

    @Override
    public ArrayList<String> getDID() throws SQLException, ClassNotFoundException {
        return qDao.getDID();
    }
}
