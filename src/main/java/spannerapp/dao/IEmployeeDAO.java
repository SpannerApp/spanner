package spannerapp.dao;

import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
public interface IEmployeeDAO {

    List<Employee> getAllUsers();

    Employee getUserByID(int ID);

    void removeUserByID(int id);

    void updateUserByID(Employee user);

    void insertUser(Employee user);

    boolean validateUser(Employee user);

}
