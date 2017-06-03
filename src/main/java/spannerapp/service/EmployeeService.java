package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IEmployeeDAO;
import spannerapp.model.Employee;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;


    @Override
    public Employee findEmployeeByID(int ID) {
        return employeeDAO.getEmployeeByID(ID);
    }
}
