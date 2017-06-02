package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.model.LoggedUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 15.04.2017.
 */
@Repository("sqlserver")
public class JdbcUserDAO implements IUserDAO {

    private static final String GET_ALL_USERS = "SELECT UserID, Login, Password FROM AuthUser WHERE 1 = 1";
    private static final String GET_USER_BY_ID = "SELECT UserID, Login, Password FROM AuthUser WHERE UserID=:id";
    private static final String DELETE_USER_BY_ID = "DELETE FROM AuthUser WHERE UserID=:id";
    private static final String UPDATE_USER_BY_ID = "UPDATE AuthUser SET Login=:login, Password=:password WHERE UserID = :id";
    private static final String ADD_USER = "INSERT INTO AuthUser (Login, Password, EmployeeID, UserTypeID) VALUES (";
    private static final String VALIDATE_USER = "SELECT * FROM AuthUser WHERE Login=:login AND Password=:password";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcUserDAO (JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<LoggedUser> getAllUsers() {
        List<LoggedUser> users = this.jdbcTemplate.query(GET_ALL_USERS, new RowMapper<LoggedUser>() {
            @Override
            public LoggedUser mapRow(ResultSet resultSet, int i) throws SQLException {
                return new LoggedUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
        return users;
    }

    @Override
    public LoggedUser getUserByID(int ID) {

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        return this.namedParameterJdbcTemplate.queryForObject(GET_USER_BY_ID, param, new RowMapper<LoggedUser>() {
            @Override
            public LoggedUser mapRow(ResultSet resultSet, int i) throws SQLException {

                return new LoggedUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
    }

    @Override
    public void removeUserByID(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        this.namedParameterJdbcTemplate.update(DELETE_USER_BY_ID, param);
    }

    @Override
    public void updateUserByID(LoggedUser user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", user.getId());
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());

        this.namedParameterJdbcTemplate.update(UPDATE_USER_BY_ID, param);
    }

    @Override
    public void insertUser(LoggedUser user) {
        StringBuilder builder = new StringBuilder();
        builder.append(ADD_USER);

        builder.append("'");
        builder.append(user.getUsername());
        builder.append("','");
        builder.append(user.getPassword());
        builder.append("',");
        builder.append(user.getEmployee().getEmployeeID());
        builder.append(",");
        builder.append("NULL");
        builder.append(")");

        this.jdbcTemplate.update(builder.toString());
    }

    @Override
    public boolean validateUser(LoggedUser user) {

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());
        LoggedUser validation = this.namedParameterJdbcTemplate.queryForObject(VALIDATE_USER, param, new RowMapper<LoggedUser>() {
            @Override
            public LoggedUser mapRow(ResultSet resultSet, int i) throws SQLException {
                return new LoggedUser(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
        if (validation != null)
            return true;
        else
            throw new UserNotFoundException(user.getUsername());
    }
}
