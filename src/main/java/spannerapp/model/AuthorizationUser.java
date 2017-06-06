package spannerapp.model;

public class AuthorizationUser {

    private Integer id;
    private String username;
    private String password;
    private Employee employee;
    private UserRole role;


    public AuthorizationUser() {};

    public AuthorizationUser(Integer ID, String username, String password)
    {
        this.id = ID;
        this.username = username;
        this.password = password;
    }

    public AuthorizationUser(Integer ID, String username, String password, Employee employee, UserRole role)
    {
        this.id = ID;
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
