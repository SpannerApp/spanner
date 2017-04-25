package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IUserDAO;
import spannerapp.dao.UserDAO;
import spannerapp.model.User;

import java.util.Collection;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Service
public class UserService {

    @Autowired
    @Qualifier("sqlserver")
    private IUserDAO userDAO;

    public Collection<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserByID(int ID) {
        return this.userDAO.getUserByID(ID);
    }

    public void removeStudentByID(int id) {
        this.userDAO.removeUserByID(id);
    }

    public void updateUser(User user){

        userDAO.updateUserByID(user);

    }

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public void validateUser(User user) { userDAO.validateUser(user); }

}
