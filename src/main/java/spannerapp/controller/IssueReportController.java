package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spannerapp.model.AuthorizationUser;
import spannerapp.model.IssueReport;
import spannerapp.service.ReportedIssueService;

import java.util.Collection;

@RestController
@RequestMapping("/reportedIssues")
public class IssueReportController {

    @Autowired
    private ReportedIssueService reportedIssueService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<IssueReport> getAllReportedIssues(){ return reportedIssueService.getAllReportedIssues();}

    @RequestMapping(value = "/getReportByID", method = RequestMethod.GET)
    public IssueReport getReportedIssueById(@RequestBody IssueReport report){ return  reportedIssueService.getReportedIssueByID(report.getID());}

    @RequestMapping(value = "/newReport", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int reportNewIssue(@RequestBody IssueReport report){
        return reportedIssueService.saveNewReport(report);
    }

    @RequestMapping(value = "/assignServiceman", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void assignServicemanToTask(@RequestBody IssueReport report){
        reportedIssueService.assignServicemanToReport(report);
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void acceptReport(@RequestBody IssueReport report){
        reportedIssueService.updateReportStatus(report);
    }

    @RequestMapping(value ="/tasksForServiceman", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<IssueReport> findReportsByLogin(@RequestBody AuthorizationUser user){return reportedIssueService.findReportsByLogin(user);}
}
