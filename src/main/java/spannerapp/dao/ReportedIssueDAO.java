package spannerapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spannerapp.dao.procedure.CreateIssueReportProcedure;
import spannerapp.model.IssueReport;
import spannerapp.model.IssueStatus;

import java.util.Collection;


@Repository
@Qualifier("reportedIssueDAO")
public class ReportedIssueDAO implements IReportedIssueDAO{

    private static final String SAVE_NEW_REPORT = "INSERT INTO ReportedIssue(DefectedMachineID, ReportingEmployeeID, IssueStatus, IssueText)";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ReportedIssueDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<IssueReport> getAllReportedIssues(){
        return null;
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
    };

}
