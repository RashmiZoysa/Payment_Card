package dao;

import bo.BoFactory;
import bo.custom.impl.*;
import dao.custom.impl.*;
import entity.Login;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DaoFactory()) : (daoFactory);
    }

    public enum DaoType {
        CUSTOMER, PAYMENT, TRANSPORTCATEGORY, CARD, QUERY,CATEGORY,USER,DRIVER,BUS

    }

    public <T> T getDao(DaoFactory.DaoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case PAYMENT:
                return (T) new PaymentDaoImpl();
            case TRANSPORTCATEGORY:
                return (T) new TransportCategoryDaoImpl();
            case CARD:
                return (T) new CardDaoImpl();
            case USER:
                return (T) new LoginDAOImpl();
            case CATEGORY:
                return (T) new CardCategoryDaoImpl();
            case DRIVER:
                return (T) new DriverDaoImpl();
            case BUS:
                return (T) new BusDaoImpl();
            case QUERY:
                return (T) new QueryDaoImpl();
            default:
                return null;

        }
    }
}
