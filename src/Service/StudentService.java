package Service;

import Model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public static final List<Student> studentsDB = new ArrayList<>();


    static{

        /* Let's add some dummy data */
        Student s1 = new Student("R-001","Sadun ", "Galle",  "077-1234567", "abc@ijse.lk");
        Student s2 = new Student("R-002","Dulanga", "Ambalngoda",  "077-2851828", "dulanga@gmail.com");
        Student s3 = new Student("R-003","Nuwan", "Kandy",  "077-1234555", "nuwan@ccg.lk");
        Student s4 = new Student("R-004","Dinesh", "Colombo",  "077-0112567", "dinesh@outlook.com");
        studentsDB.add(s1);
        studentsDB.add(s2);
        studentsDB.add(s3);
        studentsDB.add(s4);
    }

    public StudentService() {}

    public void saveStudent(Student student) {
        studentsDB.add(student);
    }

    public void updateStudent(Student student) {
        Student s = findStudent(student.getRegisterID());
        int index = studentsDB.indexOf(s);
        studentsDB.set(index, student);
    }


    public List<Student> findAllStudents() {
        return studentsDB;
    }

    public Student findStudent(String registerID) {
        for (Student student : studentsDB) {

            if (student.getRegisterID().equals(registerID)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> findStudents(String query) {
        List<Student> result = new ArrayList<>();

        for (Student student : studentsDB) {

            if (student.getRegisterID().contains(query) ||
                    student.getFullName().contains(query) ||
                    student.getAddress().contains(query) ||
                    student.getEmail().contains(query) ||
                    student.getContact().contains(query)) {
                result.add(student);
            }
        }
        return result;
    }

    public void deleteStudent(String registerID) {
        Student student = findStudent(registerID);
        studentsDB.remove(student);
    }
}
