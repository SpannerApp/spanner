package spannerapp.service;

import spannerapp.model.AuthorizationUser;
import spannerapp.model.IssueReport;

import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IReportedIssueService {

    Collection<IssueReport> getAllReportedIssues();

    IssueReport getReportedIssueByID(int ID);

    IssueReport getReportedIssueByCode(String code);

    int saveNewReport(IssueReport report);

    void updateReportStatus(IssueReport report);

    Collection<IssueReport> findReportsByLogin(AuthorizationUser user);

    void assignServicemanToReport(IssueReport report);
}
