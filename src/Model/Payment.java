package Model;

public class Payment {
    private String cid;
    private String courseName;
    private double register;
    private double payment;

    public Payment() {
    }

    public Payment(String cid, String courseName, double register, double payment) {
        this.cid = cid;
        this.courseName = courseName;
        this.register = register;
        this.payment = payment;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getRegister() {
        return register;
    }

    public void setRegister(double register) {
        this.register = register;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
