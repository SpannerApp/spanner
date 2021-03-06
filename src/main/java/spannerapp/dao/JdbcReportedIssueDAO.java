package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateIssueReportProcedure;
import spannerapp.model.Employee;
import spannerapp.model.IssueReport;
import spannerapp.model.IssueStatus;
import spannerapp.model.Machine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


@Repository
@Qualifier("reportedIssueDAO")
public class JdbcReportedIssueDAO implements IReportedIssueDAO{

    private static final String SAVE_NEW_REPORT = "INSERT INTO ReportedIssue(DefectedMachineID, ReportingEmployeeID, IssueStatus, IssueText)";
    private static final String GET_ALL_REPORTS = "SELECT * FROM ReportedIssue ri join Machine m on ri.DefectedMachineID=m.MachineID join ModelEmployee e on ri.ReportingEmployeeID=e.EmployeeID WHERE 1=1";
    private static final String UPDATE_REPORT_STATUS = "UPDATE ReportedIssue SET IssueStatus=:status WHERE ReportedIssueID=:reportedIssueID";

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
                Employee employee = new Employee(rs.getInt("EmployeeID"), rs.getString("Name"), rs.getString("Surname"), rs.getInt("PositionID"), rs.getInt("SupervisorID"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Mail"));
                Machine machine = new Machine(rs.getInt("MachineID"), rs.getString("Code"), rs.getString("Name"), rs.getString("Model"), rs.getString("Section"), rs.getString("Colour"), rs.getString("LastRepair"), null, rs.getString("Description"));

                return
                        new IssueReport(rs.getInt("ReportedIssueID") ,machine, employee, rs.getString("IssueStatus"), rs.getString("IssueText"));
            }
        });
    };

    @Override
    public IssueReport getReportedIssueByID(int ID){
        return null;
    }

    @Override
    public int saveNewReport(int machineID, int reportingEmployeeID, String issueText) {
        CreateIssueReportProcedure procedure = new CreateIssueReportProcedure(jdbcTemplate.getDataSource());
        return procedure.execute(machineID, reportingEmployeeID, IssueStatus.NEW.name(), issueText);
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
}
