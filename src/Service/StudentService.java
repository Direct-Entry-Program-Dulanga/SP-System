package Service;

import Model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final List<Student> studentsDB = new ArrayList<>();

    static{

        /* Let's add some dummy data */
        Student s1 = new Student("Sadun ", "Galle",  "077-1234567", "abc@ijse.lk");
        Student s2 = new Student("Dulanga", "Galle",  "077-1234567", "abc@ijse.lk");
        Student s3 = new Student("Nuwan", "Galle",  "077-1234567", "abc@ijse.lk");
        Student s4 = new Student("Dinesh", "Galle",  "077-1234567", "abc@ijse.lk");
        studentsDB.add(s1);
        studentsDB.add(s2);
        studentsDB.add(s3);
        studentsDB.add(s4);
    }

    public StudentService() {}

    public void saveStudent(Student student) {
        studentsDB.add(student);
    }
}
