package Service;

import Model.Student;
import Model.StudentA;

import java.util.ArrayList;
import java.util.List;

public class ManageService {
    public static final List<StudentA> studentADB = new ArrayList<>();


    static{

        /* Let's add some dummy data */
        StudentA v1 = new StudentA("R-001",5000.00, 100000.00);
        studentADB.add(v1);

    }

    public ManageService() {}

    public void saveStudent(StudentA studenta) {
        studentADB.add(studenta);
    }

    public void updateStudent(StudentA studenta) {
        StudentA s = findStudent(studenta.getRegisterID());
        int index = studentADB.indexOf(s);
        studentADB.set(index, studenta);
    }


    public List<StudentA> findAllStudents() {
        return studentADB;
    }

    public StudentA findStudent(String registerID) {
        for (StudentA studenta : studentADB) {

            if (studenta.getRegisterID().equals(registerID)) {
                return studenta;
            }
        }
        return null;
    }

    public List<StudentA> findStudents(String query) {
        List<StudentA> result = new ArrayList<>();

        for (StudentA studenta : studentADB) {

            if (studenta.getRegisterID().contains(query) ||
                    studenta.getRegisterFee().contains(query) ||
                    studenta.getPaymentFee().contains(query)) {
                result.add(studenta);
            }
        }
        return result;
    }

}
