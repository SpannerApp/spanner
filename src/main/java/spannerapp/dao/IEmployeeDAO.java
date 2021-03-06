package spannerapp.dao;

import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
public interface IEmployeeDAO {

    List<Employee> getAllEmployees();

    List<Employee> getAllServicemen();

    Employee getEmployeeByID(int ID);

    void removeEmployeeByID(int id);

    void updateUserByID(Employee employee);

    Employee getEmployeeByMail(String mail);

    int addEmployee(Employee employee);

    boolean validateUser(Employee employee);

}
