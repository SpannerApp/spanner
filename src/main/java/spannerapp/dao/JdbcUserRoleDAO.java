package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siekacz on 04.06.2017.
 */
@Repository
public class JdbcUserRoleDAO implements IUserRoleDAO {

    private static final String GET_ALL_ROLES = "SELECT * FROM Roles WHERE 1=1";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcUserRoleDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return this.namedParameterJdbcTemplate.query(GET_ALL_ROLES, new RowMapper<UserRole>() {
            @Override
            public UserRole mapRow(ResultSet rs, int i) throws SQLException {
                return new UserRole(rs.getInt("RoleID"), rs.getString("RoleName"));
            }
        });
    }
}
