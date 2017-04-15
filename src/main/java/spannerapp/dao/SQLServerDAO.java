package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spannerapp.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 15.04.2017.
 */
@Repository("sqlserver")
public class SQLServerDAO implements IUserDAO {

    private static final String GET_ALL_USERS = "SELECT UserID, Login, Password FROM AuthUser WHERE 1 = 1";

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
        return null;
    }

    @Override
    public void removeUserByID(int id) {

    }

    @Override
    public void updateUserByID(User user) {

    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public boolean validateUser(User user) {
        return false;
    }
}
