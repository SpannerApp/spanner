package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateEmployeeProcedure;
import spannerapp.model.Employee;
import spannerapp.model.LoggedUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Repository
public class JdbcModelEmployeeDAO implements IEmployeeDAO {

    private static final String ADD_EMPLOYEE = "INSERT INTO ModelEmployee (Name, Surname, PositionID, SupervisorID, Address, Phone, Mail) VALUES (";
    private static final String GET_EMPLOYEE_BY_MAIL = "SELECT * FROM ModelEmployee WHERE Mail=:mail";
    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM ModelEmployee";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcModelEmployeeDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }




    @Override
    public List<Employee> getAllUsers() {
        List<Employee> employees = this.jdbcTemplate.query(GET_ALL_EMPLOYEES, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Employee(resultSet.getInt("EmployeeID"),resultSet.getString("Name"), resultSet.getString("Surname"), resultSet.getInt("PositionID"), resultSet.getInt("SupervisorID"),resultSet.getString("Address"), resultSet.getString("Phone"), resultSet.getString("Mail"));
            }
        });
        return employees;
    }

    @Override
    public Employee getUserByID(int ID) {
        return null;
    }

    @Override
    public void removeUserByID(int id) {

    }

    @Override
    public void updateUserByID(Employee employee) {

    }

    @Override
    public Employee getEmployeeByMail(String mail) {
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("mail", mail);
        return this.namedParameterJdbcTemplate.queryForObject(GET_EMPLOYEE_BY_MAIL, param, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Name"), resultSet.getString("Surname"), resultSet.getString("Mail"));
            }
        });
    }

    @Override
    public int insertUser(Employee employee) {

        CreateEmployeeProcedure procedure = new CreateEmployeeProcedure(jdbcTemplate.getDataSource());
        return procedure.execute(employee);

    }

    @Override
    public boolean validateUser(Employee employee) {
        return false;
    }
}
