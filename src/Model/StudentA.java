package Model;

public class StudentA {
    private String registerID;
    private double registerFee;
    private double paymentFee;

    public StudentA() {
    }

    public StudentA(String registerID, double registerFee, double paymentFee) {
        this.registerID = registerID;
        this.registerFee = registerFee;
        this.paymentFee = paymentFee;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
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
