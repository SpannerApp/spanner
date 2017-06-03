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
public class EmployeeService{

    @Autowired
    private IEmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees(){ return employeeDAO.getAllUsers();}

    public Employee getEmployeeByMail(String mail){ return  employeeDAO.getEmployeeByMail(mail);}

    public int insertUser(Employee employee){ return employeeDAO.insertUser(employee);}
}
