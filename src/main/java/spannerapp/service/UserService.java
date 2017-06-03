package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IUserDAO;
import spannerapp.model.LoggedUser;

import java.util.Collection;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    @Qualifier("sqlserver")
    private IUserDAO userDAO;

    public Collection<LoggedUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public LoggedUser getUserByID(int ID) {
        return this.userDAO.getUserByID(ID);
    }

    public void removeStudentByID(int id) {
        this.userDAO.removeUserByID(id);
    }

    public void updateUser(LoggedUser user){

        userDAO.updateUserByID(user);

    }

    public void insertUser(LoggedUser user) {
        userDAO.insertUser(user);
    }

    public void validateUser(LoggedUser user) { userDAO.validateUser(user); }

}
