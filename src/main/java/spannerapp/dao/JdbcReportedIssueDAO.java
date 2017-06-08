package spannerapp.dao;

import com.sun.rowset.internal.Row;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateIssueReportProcedure;
import spannerapp.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


@Repository
@Qualifier("reportedIssueDAO")
public class JdbcReportedIssueDAO implements IReportedIssueDAO{

    private static final String SAVE_NEW_REPORT = "INSERT INTO ReportedIssue(DefectedMachineID, ReportingEmployeeID, IssueStatus, IssueText)";
    private static final String GET_ALL_REPORTS = "SELECT * FROM ReportedIssue ri join Machine m on ri.DefectedMachineID=m.MachineID join ModelEmployee e on ri.ReportingEmployeeID=e.EmployeeID WHERE 1=1";
    private static final String UPDATE_REPORT_STATUS = "UPDATE ReportedIssue SET IssueStatus=:status WHERE ReportedIssueID=:reportedIssueID";
    private static final String FIND_REPORTS_BY_USER_LOGIN = "SELECT ReportedIssueID, IssueStatus, IssueText, m.MachineID, m.Code, m.MachineName, m.Model, m.Section, m.Description, e.EmployeeID as ReportingEmployeeID, e.Name, e.Surname, au.UserID, au.Login FROM AuthUser au LEFT JOIN ReportedIssue ri on ri.AssignedServicemanID=au.UserID LEFT JOIN Machine m on ri.DefectedMachineID=m.MachineID LEFT JOIN ModelEmployee e on ri.ReportingEmployeeID=e.EmployeeID WHERE au.Login=:username";
    private static final String FIND_EMPLOYEE_BY_USER_LOGIN = "SELECT me.EmployeeID, me.Name, me.Surname, me.Address, me.Phone, me.Mail FROM ModelEmployee me LEFT JOIN AuthUser au on au.EmployeeID=me.EmployeeID WHERE au.Login=:login";
    private static final String FIND_SERVICEMAN_BY_LOGIN = "SELECT UserID, Login, Password FROM AuthUser WHERE Login = :login";
    private static final String ASSIGN_SERVICEMAN_TO_REPORT = "UPDATE ReportedIssue SET AssignedServicemanID = :servicemanID WHERE ReportedIssueID = :id";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcReportedIssueDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<IssueReport> getAllReportedIssues(){
        return namedParameterJdbcTemplate.query(GET_ALL_REPORTS, new RowMapper<IssueReport>() {
            @Override
            public IssueReport mapRow(ResultSet rs, int i) throws SQLException {
                Employee employee = new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
                Machine machine = new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("Name"), rs.getString("Model"), rs.getString("Section"), rs.getString("Colour"), rs.getString("LastRepair"), null, rs.getString("Description"));

                return new IssueReport(rs.getInt("ReportedIssueID") ,machine, employee, null, null, rs.getString("IssueStatus"), rs.getString("IssueText"));
            }
        });
    };

    @Override
    public IssueReport getReportedIssueByID(int ID){
        return null;
    }

    @Override
    public int saveNewReport(int machineID, String reportingUserLogin, String issueText) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("login", reportingUserLogin);
        Employee employee = this.namedParameterJdbcTemplate.queryForObject(FIND_EMPLOYEE_BY_USER_LOGIN, param, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail") );
            }
        });
        CreateIssueReportProcedure procedure = new CreateIssueReportProcedure(jdbcTemplate.getDataSource());
        return procedure.execute(machineID, employee.getEmployeeID(), IssueStatus.NEW.name(), issueText);
    }

    @Override
    public IssueReport getReportedIssueByCode(String code){
        return null;
    }

    @Override
    public void updateReportStatus(IssueReport report) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("status", report.getIssueStatus());
        params.addValue("reportedIssueID", report.getID());

        this.namedParameterJdbcTemplate.update(UPDATE_REPORT_STATUS, params);
    }

    @Override
    public Collection<IssueReport> findReportsByLogin(String username) {

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("username", username);
        Collection<IssueReport> collection = this.namedParameterJdbcTemplate.query(FIND_REPORTS_BY_USER_LOGIN, param, new RowMapper<IssueReport>() {
            @Override
            public IssueReport mapRow(ResultSet rs, int i) throws SQLException {
                if (rs.getInt("ReportedIssueID") == 0)
                    return null;
                AuthorizationUser user = new AuthorizationUser(rs.getInt("UserID"), rs.getString("Login"), null, null, null);
                Employee employee = new Employee(rs.getInt("ReportingEmployeeID"), rs.getString("Name"), rs.getString("Surname"), null);
                Machine machine = new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("MachineName"), rs.getString("Model"), rs.getString("Section"), null, null, null, rs.getString("Description"));
                return new IssueReport(rs.getInt("ReportedIssueID"), machine, employee, null, user, rs.getString("IssueStatus"), rs.getString("IssueText"));
            }
        });
        if(collection.contains(null))
            collection.clear();
        return collection;
    }

    @Override
    public void assignServicemanToReport(Integer id, String username) {
        MapSqlParameterSource servicemanLogin = new MapSqlParameterSource();
        servicemanLogin.addValue("login", username);
        MapSqlParameterSource paramsForAssignment = new MapSqlParameterSource();
        AuthorizationUser serviceman = this.namedParameterJdbcTemplate.queryForObject(FIND_SERVICEMAN_BY_LOGIN, servicemanLogin, new RowMapper<AuthorizationUser>() {
            @Override
            public AuthorizationUser mapRow(ResultSet rs, int i) throws SQLException {
                return new AuthorizationUser(rs.getInt("UserID"), rs.getString("Login"), rs.getString("Password"));
            }
        });

        paramsForAssignment.addValue("servicemanID", serviceman.getId());
        paramsForAssignment.addValue("id", id);
        this.namedParameterJdbcTemplate.update(ASSIGN_SERVICEMAN_TO_REPORT, paramsForAssignment);
    }
}
