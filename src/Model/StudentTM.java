package Model;

public class StudentTM {

    private String registerID;
    private String fullName;
    private String address;

    public StudentTM() {
    }

    public StudentTM(String registerID, String fullName, String address) {
        this.registerID = registerID;
        this.fullName = fullName;
        this.address = address;
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
}
