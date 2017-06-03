package spannerapp.dao;

import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
public interface IEmployeeDAO {

    List<Employee> getAllUsers();

    Employee getEmployeeByID(int ID);

    void removeEmployeeByID(int id);

    void updateUserByID(Employee user);

    Employee getEmployeeByMail(String mail);

    int insertUser(Employee user);

    boolean validateUser(Employee user);

}
