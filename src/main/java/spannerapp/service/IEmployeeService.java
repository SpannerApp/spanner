package spannerapp.service;

import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IEmployeeService{

    Employee findEmployeeByID(int ID);
    List<Employee> getAllEmployees();
    int addEmployee(Employee employee);
    List<Employee> getAllServicemen();
}
