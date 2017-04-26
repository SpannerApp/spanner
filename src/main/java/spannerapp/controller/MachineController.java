package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spannerapp.model.Machine;
import spannerapp.model.User;
import spannerapp.service.MachineService;
import spannerapp.service.UserService;

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
    public Collection<Machine> getAllMachines(){return machineService.getAllMachines();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Machine getMachineByID(@PathVariable("id") int id) {
        return machineService.getMachineByID(id);
    }}
