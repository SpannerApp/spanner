package spannerapp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.model.AuthorizationUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Repository
@Qualifier("userDAO")
public class UserDAO implements IUserDAO {

    private static Map<Integer, AuthorizationUser> users;

    static {

        users = new HashMap<Integer, AuthorizationUser>(){

            {
            put(1, new AuthorizationUser(1, "Zabek", "hehehe"));
            put(2, new AuthorizationUser(2, "Owca", "cococo"));
            put(3, new AuthorizationUser(3, "Miszu", "gdziedzie"));
            }
        };
    }

    @Override
    public Collection<AuthorizationUser> getAllUsers(){
        return this.users.values();
    }

    @Override
    public AuthorizationUser getUserByID(int ID) {
        return this.users.get(ID);
    }

    @Override
    public void removeUserByID(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUserByID(AuthorizationUser user){

        AuthorizationUser userTmp = users.get(user.getId());
        userTmp.setUsername(user.getUsername());
        userTmp.setPassword(user.getPassword());
        users.put(user.getId(), userTmp);

    }

    @Override
    public void insertUser(AuthorizationUser user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public boolean validateUser(AuthorizationUser user) {
        Collection<AuthorizationUser> usersList = users.values();
        for(AuthorizationUser iterator : usersList)
            if(iterator.getUsername().equals(user.getUsername())&&iterator.getPassword().equals(user.getPassword()))
                return true;
        throw new UserNotFoundException(user.getUsername());
    }


}
