package spannerapp.dao.procedure;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 02.06.2017.
 */
public class CreateIssueReportProcedure extends StoredProcedure {

    private static final String CREATE_ISSUE_REPORT = "SP_SAVE_NEW_REPORT";

    public CreateIssueReportProcedure(DataSource dataSource){
        super(dataSource, CREATE_ISSUE_REPORT);

        declareParameter(new SqlParameter("DefectedMachineID", Types.INTEGER));
        declareParameter(new SqlParameter("ReportingEmployeeID", Types.INTEGER));
        declareParameter(new SqlParameter("IssueStatus", Types.NVARCHAR));
        declareParameter(new SqlParameter("IssueText", Types.NVARCHAR));
        declareParameter(new SqlOutParameter("ReportedIssueID", Types.INTEGER));

        compile();
    }

    public int execute(int machineID, int reportingEmployeeID, String issueStatus, String issueText){
        Map<String, Object> row = new HashMap<>();

        row.put("DefectedMachineID", machineID);
        row.put("ReportingEmployeeID", reportingEmployeeID);
        row.put("IssueStatus", issueStatus);
        row.put("IssueText", issueText);

        Map<String, Object> output = execute(row);

        if(output.size() > 0)
            return (Integer) output.get("ReportedIssueID");
        else
            return -1;
    }
}
