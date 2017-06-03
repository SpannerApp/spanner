package spannerapp.service;

import spannerapp.model.AuthorizationUser;

import java.util.Collection;

/**
 * Created by Siekacz on 02.06.2017.
 */

public interface IUserService {

    Collection<AuthorizationUser> getAllUsers();

    AuthorizationUser getUserByID(int ID);

    void removeStudentByID(int id);

    void updateUser(AuthorizationUser user);

    void insertUser(AuthorizationUser user);

    void validateUser(AuthorizationUser user);

}
