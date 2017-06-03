package spannerapp.model;

public class AuthorizationUser {

    private int id;
    private Employee employee;
    private String username;
    private String password;


    public AuthorizationUser() {};

    public AuthorizationUser(int ID, String username, String password)
    {
        this.id = ID;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
