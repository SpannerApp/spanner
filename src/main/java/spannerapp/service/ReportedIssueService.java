package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IReportedIssueDAO;
import spannerapp.model.IssueReport;

import java.util.Collection;

/**
 * Created by emil_k on 2017-06-02.
 */
@Service
public class ReportedIssueService {

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
   };

    public int saveNewReport(IssueReport report) {
        return reportedIssueDAO.saveNewReport(report.getDefectedMachineID(), report.getReportingEmployeeID(), report.getIssueText());
    }
}

