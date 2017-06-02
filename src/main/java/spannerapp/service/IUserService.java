package spannerapp.service;

import spannerapp.model.LoggedUser;

import java.util.Collection;

/**
 * Created by Siekacz on 02.06.2017.
 */

public interface IUserService {

    Collection<LoggedUser> getAllUsers();

    LoggedUser getUserByID(int ID);

    void removeStudentByID(int id);

    void updateUser(LoggedUser user);

    void insertUser(LoggedUser user);

    void validateUser(LoggedUser user);

}
