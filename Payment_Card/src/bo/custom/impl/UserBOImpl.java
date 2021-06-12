package bo.custom.impl;


import bo.custom.UserBO;
import dao.DaoFactory;
import dao.custom.LoginDAO;
import dto.LoginDTO;
import entity.Login;

public class UserBOImpl implements UserBO {
    LoginDAO userDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);

    @Override
    public LoginDTO getAllDetails(String id) throws Exception {
        Login user=userDAO.get(id);
        return new LoginDTO(user.getName(),user.getPassword(),user.getDesignation());
    }
}
