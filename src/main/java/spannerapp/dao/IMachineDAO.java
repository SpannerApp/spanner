package spannerapp.dao;

import spannerapp.model.Machine;

import java.util.Collection;

/**
 * Created by MATI on 26.04.2017.
 */
public interface IMachineDAO {
    Collection<Machine> getAllMachines();

    Machine getMachineByID(int ID);

    Machine getMachineByCode(String code);

    // User getUserByID(int ID);

    /*void removeUserByID(int id);

    void updateUserByID(User user);

    void insertUser(User user);

    boolean validateUser(User user);*/
}
