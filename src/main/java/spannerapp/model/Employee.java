package spannerapp.model;

/**
 * Created by Siekacz on 25.04.2017.
 */
public class Employee {
    private Integer employeeID;
    private String name;
    private String surname;
    private Integer positionID;
    private Integer supervisorID;
    private String address;
    private String phone;
    private String mail;

    public Employee(){};

    public Employee(Integer employeeID, String name, String surname, Integer positionID, Integer supervisorID, String address, String phone, String mail) {
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.positionID = positionID;
        this.supervisorID = supervisorID;
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

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public Integer getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(Integer supervisorID) {
        this.supervisorID = supervisorID;
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
