package Service;

import Model.Admin;
import Model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    public static final List<Payment> paymentDB = new ArrayList<>();


    static {

        /* Let's add some dummy data */
        Payment p1 = new Payment("C-001", "DEP ", 5000.00, 100000.00);
        Payment p2 = new Payment("C-002", "GDSE ", 4000.00, 50000.00);
        Payment p3 = new Payment("C-003", "SSS ", 6000.00, 40000.00);
        Payment p4 = new Payment("C-004", "HRM ", 3000.00, 60000.00);
        Payment p5 = new Payment("C-005", "LLL ", 4500.00, 120000.00);

        paymentDB.add(p1);
        paymentDB.add(p2);
        paymentDB.add(p3);
        paymentDB.add(p4);
        paymentDB.add(p5);
    }

    public PaymentService() {}

    public List<Payment> findAllStudents() {
        return paymentDB;
    }

    public List<Payment> findStudents(String query) {
        List<Payment> result = new ArrayList<>();

        for (Payment payment : paymentDB) {

            if (payment.getCid().contains(query) ||
                    payment.getCourseName().contains(query)) {
                result.add(payment);
            }
        }
        return result;
    }

    public void saveStudent(Payment payment) {
        paymentDB.add(payment);
    }

    public Payment findStudent(String id) {
        for (Payment payment : paymentDB) {

            if (payment.getCid().equals(id)) {
                return payment;
            }
        }
        return null;
    }


    public void updateStudent(Payment payment) {
        Payment s = findStudent(payment.getCid());
        int index = paymentDB.indexOf(s);
        paymentDB.set(index, payment);
    }

    public void deleteStudent(String id) {
        Payment payment = findStudent(id);
        paymentDB.remove(payment);
    }
}
