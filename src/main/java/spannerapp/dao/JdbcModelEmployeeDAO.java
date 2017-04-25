package spannerapp.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.model.Employee;

import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Repository
public class JdbcModelEmployeeDAO implements IEmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllUsers() {
        return null;
    }

    @Override
    public Employee getUserByID(int ID) {
        return null;
    }

    @Override
    public void removeUserByID(int id) {

    }

    @Override
    public void updateUserByID(Employee user) {

    }

    @Override
    public void insertUser(Employee user) {

    }

    @Override
    public boolean validateUser(Employee user) {
        return false;
    }
}
