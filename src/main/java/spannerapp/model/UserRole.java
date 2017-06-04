package spannerapp.model;

/**
 * Created by Siekacz on 04.06.2017.
 */
public class UserRole {

    private Integer roleID;
    private String name;

    public UserRole(){};

    public UserRole(Integer roleID, String name){
        this.roleID = roleID;
        this.name = name;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
