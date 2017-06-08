package spannerapp.model;

/**
 * Created by Siekacz on 25.04.2017.
 */
public class Employee {
    private Integer employeeID;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String mail;

    public Employee(){};

    public Employee(Integer employeeID, String name, String surname, String address, String phone, String mail) {
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Employee(Integer employeeID, String name, String surname, String mail){
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
