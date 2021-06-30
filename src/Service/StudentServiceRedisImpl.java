package Service;

import Model.Student;
import Service.exception.DuplicateEntryException;
import Service.exception.NotFoundException;
import redis.clients.jedis.Jedis;
import util.JedisClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private static final String DB_PREFIX = "s#";

    private final Jedis client;

    public StudentServiceRedisImpl() {
        client = JedisClient.getInstance().getClient();
    }

    public void saveStudent(Student student) throws DuplicateEntryException {

        if (client.exists(DB_PREFIX + student.getNic())) {
            throw new DuplicateEntryException();
        }
        client.hset(DB_PREFIX + student.getNic(), student.toMap());
    }

    public void updateStudent(Student student) throws NotFoundException {

        if (!client.exists(DB_PREFIX + student.getNic())) {
            throw new NotFoundException();
        }
        client.hset(DB_PREFIX + student.getNic(), student.toMap());
    }

    public void deleteStudent(String nic) throws NotFoundException {
        if (!client.exists(DB_PREFIX + nic)) {
            throw new NotFoundException();
        }
        client.del(DB_PREFIX + nic);
    }

    private boolean exitsStudent(String nic) {
        return client.exists(DB_PREFIX + nic);
    }

    public Student findStudent(String nic) throws NotFoundException {
        if (!client.exists(DB_PREFIX + nic)) {
            throw new NotFoundException();
        }
        return Student.fromMap(DB_PREFIX + nic, client.hgetAll(DB_PREFIX + nic));
    }

    public List<Student> findAllStudents() {
        List<Student> studentList = new ArrayList<>();
        Set<String> nicList = client.keys(DB_PREFIX + "*");

        for (String nic : nicList) {
            studentList.add(Student.fromMap(nic, client.hgetAll(DB_PREFIX + nic)));
        }
        return studentList;
    }

    public List<Student> findStudents(String query) {
        List<Student> searchResult = new ArrayList<>();
        Set<String> nicList = client.keys(DB_PREFIX + "*");

        for (String nic : nicList) {

            if (nic.contains(query)){
                searchResult.add(Student.fromMap(nic, client.hgetAll(DB_PREFIX + nic)));
            }else{
                List<String> data = client.hvals(DB_PREFIX + nic);

                for (String value : data) {
                    if (value.contains(query)){
                        searchResult.add(Student.fromMap(DB_PREFIX + nic, client.hgetAll(DB_PREFIX + nic)));
                        break;
                    }
                }
            }
        }

        return searchResult;
    }
}
