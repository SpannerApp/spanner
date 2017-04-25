package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.UserNotFoundException;
import spannerapp.model.User;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<User> getAllUsers() {
        List<User> users = jdbcTemplate.query(GET_ALL_USERS, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
        return users;
    }

    @Override
    public User getUserByID(int ID) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        return namedParameterJdbcTemplate.queryForObject(GET_USER_BY_ID, param, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                return new User(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
    }

    @Override
    public void removeUserByID(int id) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        namedParameterJdbcTemplate.update(DELETE_USER_BY_ID, param);
    }

    @Override
    public void updateUserByID(User user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", user.getId());
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());

        namedParameterJdbcTemplate.update(UPDATE_USER_BY_ID, param);
    }

    @Override
    public void insertUser(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(ADD_USER);

        builder.append("'");
        builder.append(user.getUsername());
        builder.append("','");
        builder.append(user.getPassword());
        builder.append("',");
        builder.append("NULL");
        builder.append(",");
        builder.append("NULL");
        builder.append(")");

        this.jdbcTemplate.update(builder.toString());
    }

    @Override
    public boolean validateUser(User user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("login", user.getUsername());
        param.addValue("password", user.getPassword());
        User validation = namedParameterJdbcTemplate.queryForObject(VALIDATE_USER, param, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getInt("UserID"), resultSet.getString("Login"), resultSet.getString("Password"));
            }
        });
        if (validation != null)
            return true;
        else
            throw new UserNotFoundException(user.getUsername());
    }
}
