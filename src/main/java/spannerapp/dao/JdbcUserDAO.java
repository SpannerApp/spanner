package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.dao.procedure.CreateNewUserProcedure;
import spannerapp.model.AuthorizationUser;
import spannerapp.model.Employee;
import spannerapp.model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 15.04.2017.
 */
@Repository("sqlserver")
public class JdbcUserDAO implements IUserDAO {

    private static final String GET_ALL_USERS = "SELECT UserID, Login, Password, EmployeeID, RoleID FROM AuthUser WHERE 1 = 1";
    private static final String GET_USER_BY_ID = "SELECT UserID, Login, Password, EmployeeID, RoleID FROM AuthUser WHERE UserID=:id";
    private static final String DELETE_USER_BY_ID = "DELETE FROM AuthUser WHERE UserID=:id";
    private static final String UPDATE_USER_BY_ID = "UPDATE AuthUser SET Login=:login, Password=:password WHERE UserID = :id";
    private static final String ADD_USER = "INSERT INTO AuthUser (Login, Password, EmployeeID, RoleID) VALUES (";
    private static final String VALIDATE_USER = "SELECT * FROM AuthUser WHERE Login=:login AND Password=:password";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcUserDAO (JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<AuthorizationUser> getAllUsers() {
        List<AuthorizationUser> users = this.jdbcTemplate.query(GET_ALL_USERS, new RowMapper<AuthorizationUser>() {
            @Override
            public AuthorizationUser mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getInt("EmployeeID"));
                UserRole role = new UserRole();
                role.setRoleID(resultSet.getInt("RoleID"));
                return new AuthorizationUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"), employee, role);
            }
        });
        return users;
    }

    @Override
    public AuthorizationUser getUserByID(int ID) {

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        AuthorizationUser user = this.namedParameterJdbcTemplate.queryForObject(GET_USER_BY_ID, param, new RowMapper<AuthorizationUser>() {
            @Override
            public AuthorizationUser mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getInt("EmployeeID"));
                UserRole role = new UserRole();
                role.setRoleID(resultSet.getInt("RoleID"));
                return new AuthorizationUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"), employee, role);
            }
        });
        if(user != null)
            return user;
        else
            return null;
    }

    @Override
    public void removeUserByID(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        this.namedParameterJdbcTemplate.update(DELETE_USER_BY_ID, param);
    }

    @Override
    public void updateUserByID(AuthorizationUser user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", user.getId());
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());

        this.namedParameterJdbcTemplate.update(UPDATE_USER_BY_ID, param);
    }

    @Override
    public int addUser(AuthorizationUser user) {
        CreateNewUserProcedure procedure = new CreateNewUserProcedure(jdbcTemplate.getDataSource());
        return procedure.execute(user);
    }

    @Override
    public boolean validateUser(AuthorizationUser user) {

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());
        AuthorizationUser validation = this.namedParameterJdbcTemplate.queryForObject(VALIDATE_USER, param, new RowMapper<AuthorizationUser>() {
            @Override
            public AuthorizationUser mapRow(ResultSet resultSet, int i) throws SQLException {
                return new AuthorizationUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
        if (validation != null)
            return true;
        else
            throw new UserNotFoundException(user.getUsername());
    }
}
