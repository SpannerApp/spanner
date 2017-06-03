package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IssueReport getReportedIssueById(@PathVariable("id") int id){ return  reportedIssueService.getReportedIssueByID(id);}

    @RequestMapping(value = "/newReport", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int reportNewIssue(@RequestBody IssueReport report){
        return reportedIssueService.saveNewReport(report);
    }
}
