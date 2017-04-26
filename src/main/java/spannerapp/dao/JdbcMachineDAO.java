package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.model.Machine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by MATI on 26.04.2017.
 */
@Repository("sqlserver2")
public class JdbcMachineDAO implements IMachineDAO {

    private static final String GET_ALL_MACHINES = "SELECT MachineID, Code, Name, Model, Section, Colour, LastRepair, LastServiceman FROM Machine WHERE 1 = 1";
    private static final String GET_MACHINE_BY_ID = "SELECT MachineID, Code, Name, Model, Section, Colour, LastRepair, LastServiceman FROM Machine WHERE UserID=:id";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Machine> getAllMachines() {
        List<Machine> machines = jdbcTemplate.query(GET_ALL_MACHINES, new RowMapper<Machine>() {
            @Override
            public Machine mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Machine(resultSet.getInt("MachineID"), resultSet.getString("Code"),
                        resultSet.getString("Name"), resultSet.getString("Model"),
                        resultSet.getString("Section"), resultSet.getString("Colour"),
                        resultSet.getString("LastRepair"), resultSet.getString("LastServiceman"));
            }
        });
        return machines;
    }

    @Override
    public Machine getMachineByID(int ID) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        return namedParameterJdbcTemplate.queryForObject(GET_MACHINE_BY_ID, param, new RowMapper<Machine>() {
            @Override
            public Machine mapRow(ResultSet resultSet, int i) throws SQLException {

                return new Machine(resultSet.getInt("MachineID"), resultSet.getString("Code"),
                        resultSet.getString("Name"), resultSet.getString("Model"),
                        resultSet.getString("Section"),  resultSet.getString("Colour"),
                        resultSet.getString("LastRepair"),resultSet.getString("LastServiceman"));

            }
        });
    }
}

