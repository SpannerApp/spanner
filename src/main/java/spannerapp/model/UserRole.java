package spannerapp.model;

/**
 * Created by Siekacz on 04.06.2017.
 */
public class UserRole {

    private int ID;
    private String name;

    public UserRole(Integer ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
