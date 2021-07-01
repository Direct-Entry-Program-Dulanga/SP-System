package Model;

public class PaymentTM {
    private String cid;
    private String courseName;
    private String register;
    private String payment;

    public PaymentTM() {
    }

    public PaymentTM(String cid, String courseName, String register, String payment) {
        this.setCid(cid);
        this.setCourseName(courseName);
        this.setRegister(register);
        this.setPayment(payment);
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

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PaymentTM{" +
                "cid='" + cid + '\'' +
                ", courseName='" + courseName + '\'' +
                ", register='" + register + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
