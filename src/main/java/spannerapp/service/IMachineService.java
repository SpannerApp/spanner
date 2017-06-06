package spannerapp.service;

import spannerapp.model.Machine;

import java.util.Collection;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IMachineService {

    Collection<Machine> getAllMachines();
    Machine getMachineByID(int ID);
    Machine getMachineByCode(String code);
    int addNewMachine(Machine machine);

}
