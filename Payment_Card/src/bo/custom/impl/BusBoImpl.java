package bo.custom.impl;

import bo.custom.BusBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.BusDao;
import dto.BusDTO;
import entity.Bus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusBoImpl implements BusBo {
    private BusDao dao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.BUS);
    private QueryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);


    @Override
    public boolean SaveBus(BusDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(new Bus(dto.getBID(),dto.getNo(),dto.getName(),dto.getRoute(),dto.getDate(),dto.getFacilities(),dto.getType(),dto.getOwnerName(),dto.getOwnerNIC(),dto.getOwnerAddress(),dto.getOwnerContactNo()));
    }

    @Override
    public BusDTO getBus(String bid) throws Exception {
        Bus bus =dao.get(bid);
        return new BusDTO( bus.getBID(), bus.getNo(), bus.getName(),bus.getRoute(), bus.getDate(), bus.getFacilities(), bus.getType(), bus.getOwnerName(), bus.getOwnerNIC(), bus.getOwnerAddress(), bus.getOwnerContactNo());
    }

    @Override
    public int getBusCount() throws SQLException, ClassNotFoundException {
            return qDao.getBusCount();
    }

    @Override
    public String getBID() throws SQLException, ClassNotFoundException {
            return qDao.getbid();
    }

    @Override
    public boolean deleteBus(String bid) throws Exception {
        return false;
    }



    @Override
    public ArrayList<String> getbid() throws Exception {
        return dao.getId();
    }


    @Override
    public ArrayList<BusDTO> loadAllDetail() throws Exception {
        List<Bus> all = dao.getAll();
        ArrayList<BusDTO> busDTOS = new ArrayList<>();
        for(Bus b : all){
            busDTOS.add(new BusDTO(
                    b.getBID(),
                    b.getNo(),
                    b.getName(),
                    b.getRoute(),
                    b.getDate(),
                    b.getFacilities(),
                    b.getType(),
                    b.getOwnerName(),
                    b.getOwnerNIC(),
                    b.getOwnerAddress(),
                    b.getOwnerContactNo()
            ));
        }
        return busDTOS;

    }

}
