package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateEmployeeProcedure;
import spannerapp.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Repository
public class JdbcEmployeeDAO implements IEmployeeDAO {

    private static final String ADD_EMPLOYEE = "INSERT INTO ModelEmployee (Name, Surname, PositionID, SupervisorID, Address, Phone, Mail) VALUES (";
    private static final String GET_EMPLOYEE_BY_MAIL = "SELECT * FROM ModelEmployee WHERE Mail=:mail";
    private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM ModelEmployee WHERE EmployeeID=:id";
    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM ModelEmployee WHERE 1=1";
    private static final String GET_ALL_SERVICEMEN = "SELECT * FROM ModelEmployee me JOIN AuthUser au on au.EmployeeID = me.EmployeeID WHERE au.RoleID=2 GROUP BY me.Name, me.Surname, me.EmployeeID, me.PositionID, me.SupervisorID, me.Address, me.Mail, me.Phone, au.UserID, au.Login, au.EmployeeID, au.Password, au.RoleID";
    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM AuthUser WHERE EmployeeID=:id " +
            "DELETE FROM ModelEmployee WHERE EmployeeID=:id";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcEmployeeDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.namedParameterJdbcTemplate.query(GET_ALL_EMPLOYEES, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
            }
        });
    }

    @Override
    public List<Employee> getAllServicemen() {
        return this.namedParameterJdbcTemplate.query(GET_ALL_SERVICEMEN, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
            }
        });
    }

    @Override
    public Employee getEmployeeByID(int ID) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        return this.namedParameterJdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, param, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
            }
        });
    }

    @Override
    public void removeEmployeeByID(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        this.namedParameterJdbcTemplate.update(DELETE_EMPLOYEE_BY_ID, param);
    }

    @Override
    public void updateUserByID(Employee employee) {

    }

    public void updateEmployeeByID(Employee employee) {

    }

    @Override
    public Employee getEmployeeByMail(String mail) {
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("mail", mail);
        return this.namedParameterJdbcTemplate.queryForObject(GET_EMPLOYEE_BY_MAIL, param, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
            }
        });
    }

    @Override
    public int addEmployee(Employee employee) {

        CreateEmployeeProcedure procedure = new CreateEmployeeProcedure(jdbcTemplate.getDataSource());
        return procedure.execute(employee);

    }

    @Override
    public boolean validateUser(Employee employee) {
        return false;
    }
}
