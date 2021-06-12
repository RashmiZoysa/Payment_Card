package bo;

import bo.custom.impl.*;
import dao.DaoFactory;
import dao.custom.impl.*;
import entity.Customer;

import java.net.Proxy;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (null==boFactory) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoType{
        CUSTOMER,PAYMENT,TRANSPORTCATEGORY,CARD,USER,CATEGORY,DRIVER,BUS

    }
    public<T>T getBO(BoType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case PAYMENT:
                return (T) new PaymentBoImpl();
            case TRANSPORTCATEGORY:
                return (T) new TransportCategoryBoImpl();
            case CARD:
                return (T) new CardBoImpl();
            case USER:
                return (T) new UserBOImpl();
            case CATEGORY:
                return (T) new CategoryBoImpl();
            case DRIVER:
                return (T) new DriverBoImpl();
            case BUS:
                return (T) new BusBoImpl();
            default:
                return null;

        }
    }
}
