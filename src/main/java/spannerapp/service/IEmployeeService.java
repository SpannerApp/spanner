package spannerapp.service;

import spannerapp.model.Employee;

import java.util.List;


public interface IEmployeeService{

    Employee findEmployeeByID(int ID);
    List<Employee> getAllEmployees();
    int addEmployee(Employee employee);
    List<Employee> getAllServicemen();
    void removeEmployeeByID(int id);

}
