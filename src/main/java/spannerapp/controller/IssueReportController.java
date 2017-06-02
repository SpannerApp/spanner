package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spannerapp.model.IssueReport;
import spannerapp.service.ReportedIssueService;

import java.util.Collection;

@RestController
@RequestMapping("/reportedIssues")
public class IssueReportController {

    @Autowired
    private ReportedIssueService reportedIsueService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<IssueReport> getAllReportedIssues(){ return reportedIsueService.getAllReportedIssues();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IssueReport getReportedIssueById(@PathVariable("id") int id){ return  reportedIsueService.getReportedIssueByID(id);}
}
