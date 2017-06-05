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
    int addNewMachine(Machine machine);

}
