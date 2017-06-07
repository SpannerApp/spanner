package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IReportedIssueDAO;
import spannerapp.model.AuthorizationUser;
import spannerapp.model.IssueReport;

import java.util.Collection;
import java.util.List;

/**
 * Created by emil_k on 2017-06-02.
 */
@Service
public class ReportedIssueService implements IReportedIssueService {

    @Autowired
    private IReportedIssueDAO reportedIssueDAO;

    public  Collection<IssueReport> getAllReportedIssues(){
       return reportedIssueDAO.getAllReportedIssues();
   };

    public IssueReport getReportedIssueByID(int ID){
       return reportedIssueDAO.getReportedIssueByID(ID);
   };

    public IssueReport getReportedIssueByCode(String code){
       return reportedIssueDAO.getReportedIssueByCode(code);
   }

    public int saveNewReport(IssueReport report) {
        return reportedIssueDAO.saveNewReport(report.getDefectedMachine().getId(), report.getReportingUser().getUsername(), report.getIssueText());
    }

    public void updateReportStatus(IssueReport report) {
        reportedIssueDAO.updateReportStatus(report);
    }

    public Collection<IssueReport> findReportsByLogin(AuthorizationUser user) { return reportedIssueDAO.findReportsByLogin(user.getUsername()); }

    @Override
    public void assignServicemanToReport(IssueReport report) {
        reportedIssueDAO.assignServicemanToReport(report.getID(), report.getAssignedServiceman().getUsername());
    }
}

