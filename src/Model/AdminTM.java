package Model;

public class AdminTM {

    private String nic;
    private String fullName;
    private String address;
    private String paymentFee;

    public AdminTM() {
    }

    public AdminTM(String nic, String fullName, String address, String paymentFee) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
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

    public String getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(String paymentFee) {
        this.paymentFee = paymentFee;
    }
}
