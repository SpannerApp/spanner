package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IMachineDAO;
import spannerapp.model.Machine;

import java.util.Collection;

/**
 * Created by MATI on 26.04.2017.
 */
@Service
public class MachineService implements IMachineService{

    @Autowired
    @Qualifier("sqlserver2")
    private IMachineDAO machineDAO;

    public Collection<Machine> getAllMachines() {
        return machineDAO.getAllMachines();
    }

    public Machine getMachineByID(int ID) {
        return this.machineDAO.getMachineByID(ID);
    }

    public Machine getMachineByCode(String code) {
        return this.machineDAO.getMachineByCode(code);
    }
}
