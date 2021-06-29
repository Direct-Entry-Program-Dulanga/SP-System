package Service;

import Model.Student;
import Service.exception.DuplicateEntryException;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceRedisImpl {
//    public static final List<Student> studentsDB = new ArrayList<>();
//
//
//    static{
//
//        /* Let's add some dummy data */
//        Student s1 = new Student("945678124v", "Sadun ", "Colombo", "077-1234567", "abc@ijse.lk");
//        Student s2 = new Student("961710065v", "Dulanga ", "Galle", "077-1234567", "abc@ijse.lk");
//        Student s3 = new Student("965678135v", "Nuwan ", "Matara", "077-1234567", "abc@ijse.lk");
//        Student s4 = new Student("975675674v", "Amara ", "Kandy", "077-1234567", "abc@ijse.lk");
//        Student s5 = new Student("941358124v", "Kamal ", "Jaffna", "077-1234567", "abc@ijse.lk");
//        studentsDB.add(s1);
//        studentsDB.add(s2);
//        studentsDB.add(s3);
//        studentsDB.add(s4);
//        studentsDB.add(s5);
//    }

    public StudentServiceRedisImpl() {}

    public void saveStudent(Student student) throws DuplicateEntryException {
        Jedis client = new Jedis("localhost", 5050);
        if(client.exists(student.getNic())){
            throw new DuplicateEntryException();
        }
        client.hset(student.getNic(), "name", student.getFullName());
        client.hset(student.getNic(), "address", student.getAddress());
        client.hset(student.getNic(), "contact", student.getContact());
        client.hset(student.getNic(), "email", student.getEmail());

    }

    public void updateStudent(Student student) throws DuplicateEntryException {
        Jedis client = new Jedis("localhost", 5050);
        if(!client.exists(student.getNic())){
            throw new DuplicateEntryException();
        }
    }


    public List<Student> findAllStudents() {
        return null;
    }

    public Student findStudent(String registerID) {
        return null;
    }

    public List<Student> findStudents(String query) {

        return null;
    }
}
