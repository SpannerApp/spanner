package spannerapp.dao;

import spannerapp.model.User;

import java.util.Collection;

/**
 * Created by Siekacz on 24.03.2017.
 */
public interface IUserDAO {
    Collection<User> getAllUsers();

    User getUserByID(int ID);

    void removeUserByID(int id);

    void updateUserByID(User user);

    void insertUser(User user);

    boolean validateUser(User user);
}
