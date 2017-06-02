package spannerapp.model;

public class IssueReport {
    public String availability;
    public String serialNumber;
    public String model;
    public String department;

    public String getAvailibility() {
        return availability;
    }

    public void setAvailibility(String availibility) {
        this.availability = availibility;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public IssueReport(){}

    public IssueReport(String availability, String serialNumber, String model, String department) {
        this.availability = availability;
        this.serialNumber = serialNumber;
        this.model = model;
        this.department = department;
    }
}

