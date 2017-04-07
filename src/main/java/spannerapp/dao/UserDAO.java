package spannerapp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 23.03.2017.
 */
@Repository
@Qualifier("userDAO")
public class UserDAO implements IUserDAO {

    private static Map<Integer, User> users;

    static {

        users = new HashMap<Integer, User>(){

            {
            put(1, new User(1, "Zabek", "hehehe"));
            put(2, new User(2, "Owca", "cococo"));
            put(3, new User(3, "Miszu", "gdziedzie"));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    @Override
    public User getUserByID(int ID) {
        return this.users.get(ID);
    }

    @Override
    public void removeUserByID(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUserByID(User user){

        User userTmp = users.get(user.getId());
        userTmp.setUsername(user.getUsername());
        userTmp.setPassword(user.getPassword());
        users.put(user.getId(), userTmp);

    }

    @Override
    public void insertUser(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public boolean validateUser(User user) {
        Collection<User> usersList = users.values();
        for(User iterator : usersList)
            if(iterator.getUsername().equals(user.getUsername())&&iterator.getPassword().equals(user.getPassword()))
                return true;
        throw new UserNotFoundException(user.getUsername());
    }


}
