package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IUserDAO;
import spannerapp.model.AuthorizationUser;

import java.util.Collection;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    @Qualifier("sqlserver")
    private IUserDAO userDAO;

    public Collection<AuthorizationUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public AuthorizationUser getUserByID(int ID) {
        return this.userDAO.getUserByID(ID);
    }

    public void removeStudentByID(int id) {
        this.userDAO.removeUserByID(id);
    }

    public void updateUser(AuthorizationUser user){

        userDAO.updateUserByID(user);

    }

    public int addUser(AuthorizationUser user) {
        return userDAO.addUser(user);
    }

    public void validateUser(AuthorizationUser user) { userDAO.validateUser(user); }

}
