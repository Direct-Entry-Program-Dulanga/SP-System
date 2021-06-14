package Model;

public class AdminTM {

    private String nic;
    private String fullName;
    private String address;
    private double registerFee;
    private double paymentFee;

    public AdminTM() {
    }

    public AdminTM(String nic, String fullName, String address, double registerFee, double paymentFee) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.registerFee = registerFee;
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
