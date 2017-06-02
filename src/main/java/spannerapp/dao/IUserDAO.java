package spannerapp.dao;

import spannerapp.model.LoggedUser;

import java.util.Collection;

/**
 * Created by Siekacz on 24.03.2017.
 */
public interface IUserDAO {
    Collection<LoggedUser> getAllUsers();

    LoggedUser getUserByID(int ID);

    void removeUserByID(int id);

    void updateUserByID(LoggedUser user);

    void insertUser(LoggedUser user);

    boolean validateUser(LoggedUser user);
}
