package spannerapp.dao;

import spannerapp.model.AuthorizationUser;

import java.util.Collection;

/**
 * Created by Siekacz on 24.03.2017.
 */
public interface IUserDAO {
    Collection<AuthorizationUser> getAllUsers();

    AuthorizationUser getUserByID(int ID);

    void removeUserByID(int id);

    void updateUserByID(AuthorizationUser user);

    void insertUser(AuthorizationUser user);

    boolean validateUser(AuthorizationUser user);
}
