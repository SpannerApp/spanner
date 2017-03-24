package spannerapp.model;

/**
 * Created by Siekacz on 23.03.2017.
 */
public class User {

    private int id;
    private String username;
    private String password;

    public User () {};

    public User (int ID, String username, String password)
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
}
