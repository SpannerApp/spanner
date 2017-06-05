package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateMachineProcedure;
import spannerapp.model.Employee;
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

    private static final String GET_ALL_MACHINES = "SELECT MachineID, Code, MachineName, Model, Section, Colour, LastRepair, LastServicemanID, Description, EmployeeID, Name, Surname, PositionID, SupervisorID, Address, Phone, Mail FROM Machine m LEFT JOIN ModelEmployee me on m.LastServicemanID=me.EmployeeID WHERE 1 = 1";
    private static final String GET_MACHINE_BY_ID = "SELECT MachineID, Code, MachineName, Model, Section, Colour, LastRepair, LastServicemanID, Description, EmployeeID, Name, Surname, PositionID, SupervisorID, Address, Phone, Mail FROM Machine m LEFT JOIN ModelEmployee me on m.LastServicemanID=me.EmployeeID WHERE MachineID=:id";
    private static final String GET_MACHINE_BY_CODE = "SELECT MachineID, Code, MachineName, Model, Section, Colour, LastRepair, LastServicemanID, Description, EmployeeID, Name, Surname, PositionID, SupervisorID, Address, Phone, Mail FROM Machine m LEFT JOIN ModelEmployee me on m.LastServicemanID=me.EmployeeID WHERE Code=:code";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcMachineDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<Machine> getAllMachines() {
        List<Machine> machines = jdbcTemplate.query(GET_ALL_MACHINES, new RowMapper<Machine>() {
            @Override
            public Machine mapRow(ResultSet rs, int i) throws SQLException {
                Employee serviceman = new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
                return new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("MachineName"), rs.getString("Model"), rs.getString("Section"), rs.getString("Colour"), rs.getString("LastRepair"), serviceman, rs.getString("Description"));
            }
        });
        return machines;
    }

    @Override
    public Machine getMachineByID(int ID) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", ID);

        return this.namedParameterJdbcTemplate.queryForObject(GET_MACHINE_BY_ID, param, new RowMapper<Machine>() {
            @Override
            public Machine mapRow(ResultSet rs, int i) throws SQLException {
                Employee serviceman = new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
                return new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("MachineName"), rs.getString("Model"), rs.getString("Section"), rs.getString("Colour"), rs.getString("LastRepair"), serviceman, rs.getString("Description"));

            }
        });
    }

    @Override
    public Machine getMachineByCode(String code) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("code", code);

        return this.namedParameterJdbcTemplate.queryForObject(GET_MACHINE_BY_CODE, param, new RowMapper<Machine>() {
            @Override
            public Machine mapRow(ResultSet rs, int i) throws SQLException {
                Employee serviceman = new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
                return new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("MachineName"), rs.getString("Model"), rs.getString("Section"), rs.getString("Colour"), rs.getString("LastRepair"), serviceman, rs.getString("Description"));
            }
        });
    }

    @Override
    public int addNewMachine(Machine machine) {
        CreateMachineProcedure createMachineProcedure = new CreateMachineProcedure(jdbcTemplate.getDataSource());
        return createMachineProcedure.execute(machine);
    }
}

