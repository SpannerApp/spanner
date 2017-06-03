package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IEmployeeDAO;
import spannerapp.dao.IUserDAO;
import spannerapp.model.Employee;
import spannerapp.model.AuthorizationUser;
import spannerapp.model.RegistrationFormModel;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Service
public class RegistrationService implements IRegistrationService {

    @Autowired
    @Qualifier("sqlserver")
    private IUserDAO userDAO;
    @Autowired
    private IEmployeeDAO employeeDAO;

    public void registerNewUser(RegistrationFormModel model) {
        Employee employee = new Employee();
        employee.setName(model.getName());
        employee.setSurname(model.getSurname());
        employee.setMail(model.getEmail());

        Integer employeeID = employeeDAO.insertUser(employee);


        AuthorizationUser user = new AuthorizationUser();
        user.setUsername(model.getLogin());
        user.setPassword(model.getPassword());
        user.setEmployee(employee);

        userDAO.insertUser(user);
    }
}
