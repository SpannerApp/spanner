package spannerapp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.model.LoggedUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Repository
@Qualifier("userDAO")
public class UserDAO implements IUserDAO {

    private static Map<Integer, LoggedUser> users;

    static {

        users = new HashMap<Integer, LoggedUser>(){

            {
            put(1, new LoggedUser(1, "Zabek", "hehehe"));
            put(2, new LoggedUser(2, "Owca", "cococo"));
            put(3, new LoggedUser(3, "Miszu", "gdziedzie"));
            }
        };
    }

    @Override
    public Collection<LoggedUser> getAllUsers(){
        return this.users.values();
    }

    @Override
    public LoggedUser getUserByID(int ID) {
        return this.users.get(ID);
    }

    @Override
    public void removeUserByID(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUserByID(LoggedUser user){

        LoggedUser userTmp = users.get(user.getId());
        userTmp.setUsername(user.getUsername());
        userTmp.setPassword(user.getPassword());
        users.put(user.getId(), userTmp);

    }

    @Override
    public void insertUser(LoggedUser user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public boolean validateUser(LoggedUser user) {
        Collection<LoggedUser> usersList = users.values();
        for(LoggedUser iterator : usersList)
            if(iterator.getUsername().equals(user.getUsername())&&iterator.getPassword().equals(user.getPassword()))
                return true;
        throw new UserNotFoundException(user.getUsername());
    }


}
