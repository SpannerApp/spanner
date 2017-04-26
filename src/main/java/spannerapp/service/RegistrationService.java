package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spannerapp.dao.IEmployeeDAO;
import spannerapp.dao.IUserDAO;
import spannerapp.model.Employee;
import spannerapp.model.RegistrationFormModel;
import spannerapp.model.User;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Service
public class RegistrationService {

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

        employeeDAO.insertUser(employee);

        User user = new User();
        user.setUsername(model.getLogin());
        user.setPassword(model.getPassword());

        userDAO.insertUser(user);
    }
}
