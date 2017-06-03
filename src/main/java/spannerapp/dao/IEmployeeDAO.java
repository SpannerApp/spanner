package spannerapp.dao;

import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
public interface IEmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployeeByID(int ID);

    void removeEmployeeByID(int id);

    void updateUserByID(Employee employee);

    Employee getEmployeeByMail(String mail);

    int insertEmployee(Employee employee);

    boolean validateUser(Employee employee);

}
