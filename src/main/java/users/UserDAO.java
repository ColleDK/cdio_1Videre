package users;

//import dataStorage.Data;
import exceptions.DALException;

import java.util.List;

public class UserDAO implements IUserDAO {
    private UserDTO dto;
//    private Data data;
//
//    public UserDAO(Data data){this.data = data;}
    public UserDAO(){}

    public UserDTO getUser(int userId) throws DALException {
        return new UserDTO()
    }


    public List<UserDTO> getUserList() throws DALException {
        return null;
    }


    public void createUser(UserDTO user) throws DALException {

    }


    public void updateUser(UserDTO user) throws DALException {


    }


    public void deleteUser(int userId) throws DALException {

    }
}
