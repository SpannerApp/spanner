package spannerapp.dao;

import com.microsoft.sqlserver.jdbc.ISQLServerBulkRecord;
import spannerapp.model.IssueReport;
import spannerapp.model.Machine;

import java.util.Collection;


public interface IReportedIssueDAO {

    Collection<IssueReport> getAllReportedIssues();
    IssueReport getReportedIssueByID(int ID);
    int saveNewReport(int machineID, int reportingEmployeeID, String issueText);
    IssueReport getReportedIssueByCode(String code);
    void updateReportStatus(IssueReport report);
    Collection<IssueReport> findReportsByLogin(String username);
}
