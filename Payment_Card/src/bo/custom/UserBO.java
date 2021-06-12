package bo.custom;

import dto.LoginDTO;

public interface UserBO {

    LoginDTO getAllDetails(String id) throws Exception;
}
