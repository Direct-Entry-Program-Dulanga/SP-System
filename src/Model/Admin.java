package Model;

import java.util.HashMap;
import java.util.Map;

public class Admin {
    private String nic;
    private String fullName;
    private String address;
    private String contact;
    private String email;
    private String paymentFee;

    public Admin() {
    }

    public Admin(String nic, String fullName, String address, String contact, String email, String registerFee, String paymentFee) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.paymentFee = paymentFee;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(String paymentFee) {
        this.paymentFee = paymentFee;
    }
}
