package spannerapp.dao;

import com.microsoft.sqlserver.jdbc.ISQLServerBulkRecord;
import spannerapp.model.IssueReport;
import spannerapp.model.Machine;

import java.util.Collection;


public interface IReportedIssueDAO {
    Collection<IssueReport> getAllReportedIssues();

    IssueReport getReportedIssueByID(int ID);

    IssueReport getReportedIssueByCode(String code);
}
