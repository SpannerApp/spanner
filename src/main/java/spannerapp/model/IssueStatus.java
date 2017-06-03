package spannerapp.model;

/**
 * Created by Siekacz on 02.06.2017.
 */
public enum IssueStatus {
    NEW("NEW");

    private final String status;

    private IssueStatus(String status) { this.status= status; }

    public String getStatus() {
        return status;
    }
}
