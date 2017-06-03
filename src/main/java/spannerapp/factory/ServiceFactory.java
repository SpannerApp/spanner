package spannerapp.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spannerapp.service.IEmployeeService;
import spannerapp.service.IMachineService;
import spannerapp.service.IRegistrationService;
import spannerapp.service.IUserService;

/**
 * Created by Siekacz on 02.06.2017.
 */
public class ServiceFactory {

    private static final Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IRegistrationService registrationService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IMachineService machineService;


    public IUserService getUserService() {
        return userService;
    }

    public IRegistrationService getRegistrationService() {
        return registrationService;
    }

    public IEmployeeService getEmployeeService() {
        return employeeService;
    }

    public IMachineService getMachineService() {
        return machineService;
    }
}
