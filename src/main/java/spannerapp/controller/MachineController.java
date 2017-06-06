package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spannerapp.CreatingException;
import spannerapp.model.Machine;
import spannerapp.service.MachineService;

import java.util.Collection;

/**
 * Created by MATI on 26.04.2017.
 */
@RestController
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Machine> getAllMachines() {
        return machineService.getAllMachines();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Machine getMachineByID(@PathVariable("id") int id) {
        return machineService.getMachineByID(id);
    }

    @RequestMapping(value = "/findByCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Machine getMachineBySerialNumber(@RequestBody Machine machine) {
        return machineService.getMachineByCode(machine.getCode());
    }

    @RequestMapping(value = "/addMachine", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addNewMachine(@RequestBody Machine machine) throws CreatingException{
        int result = machineService.addNewMachine(machine);
        if (result == -1)
            throw new CreatingException("machine");
        return result;
    }
}
