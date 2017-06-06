package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IEmployeeDAO;
import spannerapp.model.Employee;

import java.util.List;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public List<Employee> getAllServicemen() {
        return employeeDAO.getAllServicemen();
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    public void removeEmployeeByID(int id) {
        this.employeeDAO.removeEmployeeByID(id);
    }

}
