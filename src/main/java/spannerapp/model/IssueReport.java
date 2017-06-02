package spannerapp.model;

public class IssueReport {

    private int ID;
    private int defectedMachineID;
    private int reportingEmployeeID;
    private String issueStatus;
    private String issueText;

    public IssueReport(){}

    public IssueReport(int defectedMachineID, int reportingEmployeeID, String issueStatus, String issueText) {
        this.defectedMachineID = defectedMachineID;
        this.reportingEmployeeID = reportingEmployeeID;
        this.issueStatus = issueStatus;
        this.issueText = issueText;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIssueText() {
        return issueText;
    }

    public void setIssueText(String issueText) {
        this.issueText = issueText;
    }

    public int getDefectedMachineID() {
        return defectedMachineID;
    }

    public void setDefectedMachineID(int defectedMachineID) {
        this.defectedMachineID = defectedMachineID;
    }

    public int getReportingEmployeeID() {
        return reportingEmployeeID;
    }

    public void setReportingEmployeeID(int reportingEmployeeID) {
        this.reportingEmployeeID = reportingEmployeeID;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}

