package spannerapp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spannerapp.model.IssueReport;
import spannerapp.model.Machine;
import spannerapp.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Qualifier("reportedIssueDAO")
public class ReportedIssueDAO  implements  IReportedIssueDAO{

    private static Map<Integer, IssueReport> reportedIssues;
    static {

        reportedIssues = new HashMap<Integer, IssueReport>(){

            {
                put(1, new IssueReport("available", "1234567890", "modelXDF", "HALA"));
            }
        };

    }

    @Override
    public Collection<IssueReport> getAllReportedIssues(){
        return this.reportedIssues.values();
    };

    @Override
    public IssueReport getReportedIssueByID(int ID){
        return this.reportedIssues.get(ID);
    };

    @Override
    public IssueReport getReportedIssueByCode(String code){
        return null;
    };

}
