package Model;

public class Admin {
    private String registerID;
    private String fullName;
    private String address;
    private String contact;
    private String email;
    private double registerFee;
    private double paymentFee;

    public Admin() {
    }

    public Admin(String registerID, String fullName, String address, String contact, String email, double registerFee, double paymentFee) {
        this.registerID = registerID;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.registerFee = registerFee;
        this.paymentFee = paymentFee;
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

    public double getRegisterFee() {
        return registerFee;
    }

    public void setRegisterFee(double registerFee) {
        this.registerFee = registerFee;
    }

    public double getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(double paymentFee) {
        this.paymentFee = paymentFee;
    }
}
