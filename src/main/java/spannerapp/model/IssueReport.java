package spannerapp.model;

public class IssueReport {

    private Integer id;
    private Machine defectedMachine;
    private Employee reportingEmployee;
    private AuthorizationUser assignedServiceman;
    private String issueStatus;
    private String issueText;

    public IssueReport(){}

    public IssueReport(Integer id, Machine defectedMachine, Employee reportingEmployee, AuthorizationUser assignedServiceman, String issueStatus, String issueText) {
        this.id=id;
        this.defectedMachine = defectedMachine;
        this.reportingEmployee = reportingEmployee;
        this.assignedServiceman = assignedServiceman;
        this.issueStatus = issueStatus;
        this.issueText = issueText;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getIssueText() {
        return issueText;
    }

    public void setIssueText(String issueText) {
        this.issueText = issueText;
    }

    public Machine getDefectedMachine() {
        return defectedMachine;
    }

    public void setDefectedMachine(Machine defectedMachine) {
        this.defectedMachine = defectedMachine;
    }

    public Employee getReportingEmployee() {
        return reportingEmployee;
    }

    public void setReportingEmployee(Employee reportingEmployee) {
        this.reportingEmployee = reportingEmployee;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public AuthorizationUser getAssignedServiceman() {
        return assignedServiceman;
    }

    public void setAssignedServiceman(AuthorizationUser assignedServiceman) {
        this.assignedServiceman = assignedServiceman;
    }
}

