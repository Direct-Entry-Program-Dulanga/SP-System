package Model;

import java.time.LocalDate;

public class Student {

    private String registerID;
    private String fullName;
    private String address;
    private String contact;
    private String email;

    public Student(String s, double v, double v1) {
    }

    public Student(String registerID, String fullName, String address, String contact, String email) {
        this.registerID = registerID;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
