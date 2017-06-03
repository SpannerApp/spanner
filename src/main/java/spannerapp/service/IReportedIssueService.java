package spannerapp.service;

import spannerapp.model.IssueReport;

import java.util.Collection;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IReportedIssueService {

    Collection<IssueReport> getAllReportedIssues();

    IssueReport getReportedIssueByID(int ID);

    IssueReport getReportedIssueByCode(String code);

    void saveNewReport(int defectedMachineID, int reportingEmployeeID, String issueText);

}
