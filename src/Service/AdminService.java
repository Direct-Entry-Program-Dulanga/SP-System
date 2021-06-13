package Service;

import Model.Admin;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    public static final List<Admin> adminDB = new ArrayList<>();


    static {

        /* Let's add some dummy data */
        Admin a1 = new Admin("R-001", "Sadun ", "Colombo", "077-1234567", "abc@ijse.lk", 5000.00, 100000.00);
        Admin a2 = new Admin("R-002", "Dulanga ", "Galle", "077-1234567", "abc@ijse.lk", 5000.00, 100000.00);
        Admin a3 = new Admin("R-003", "Nuwan ", "Matara", "077-1234567", "abc@ijse.lk", 5000.00, 100000.00);
        Admin a4 = new Admin("R-004", "Amara ", "Kandy", "077-1234567", "abc@ijse.lk", 5000.00, 100000.00);
        Admin a5 = new Admin("R-005", "Kamal ", "Jaffna", "077-1234567", "abc@ijse.lk", 5000.00, 100000.00);

        adminDB.add(a1);
        adminDB.add(a2);
        adminDB.add(a3);
        adminDB.add(a4);
        adminDB.add(a5);
    }

    public AdminService() {}

    public List<Admin> findAllStudents() {
        return adminDB;
    }

    public List<Admin> findStudents(String query) {
        List<Admin> result = new ArrayList<>();

        for (Admin admin : adminDB) {

            if (admin.getRegisterID().contains(query) ||
                    admin.getFullName().contains(query)) {
                result.add(admin);
            }
        }
        return result;
    }
}
