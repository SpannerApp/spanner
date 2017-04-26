package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Repository
public class JdbcModelEmployeeDAO implements IEmployeeDAO {

    private static final String ADD_EMPLOYEE = "INSERT INTO ModelEmployee (Name, Surname, PositionID, SupervisorID, Address, Phone, Mail) VALUES (";
    private static final String GET_EMPLOYEE_BY_MAIL = "SELECT * FROM ModelEmployee WHERE Mail=:mail";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcModelEmployeeDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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
    public void insertUser(Employee employee) {

        StringBuilder builder = new StringBuilder();
        builder.append(ADD_EMPLOYEE);

        builder.append("'");
        builder.append(employee.getName());
        builder.append("','");
        builder.append(employee.getSurname());
        builder.append("',");
        builder.append("NULL");
        builder.append(",");
        builder.append("NULL");
        builder.append(",");
        builder.append("NULL");
        builder.append(",");
        builder.append("NULL");
        builder.append(",'");
        builder.append(employee.getMail());
        builder.append("')");

        this.jdbcTemplate.update(builder.toString());

    }

    @Override
    public boolean validateUser(Employee employee) {
        return false;
    }
}
