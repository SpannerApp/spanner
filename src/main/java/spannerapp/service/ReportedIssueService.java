package spannerapp.service;

import org.springframework.stereotype.Service;
import spannerapp.dao.IReportedIssueDAO;
import spannerapp.model.IssueReport;

import java.util.Collection;

/**
 * Created by emil_k on 2017-06-02.
 */
@Service
public class ReportedIssueService {

    private IReportedIssueDAO reportedIssueaDAO;

   public  Collection<IssueReport> getAllReportedIssues(){
       return reportedIssueaDAO.getAllReportedIssues();
   };

   public IssueReport getReportedIssueByID(int ID){
       return reportedIssueaDAO.getReportedIssueByID(ID);
   };

   public IssueReport getReportedIssueByCode(String code){
       return reportedIssueaDAO.getReportedIssueByCode(code);
   };
}

