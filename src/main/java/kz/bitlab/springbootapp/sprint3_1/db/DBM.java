package kz.bitlab.springbootapp.sprint3_1.db;

import kz.bitlab.springbootapp.sprint3_1.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DBM {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1l, "Vasya", "Pupkin", 71, "C"));
        students.add(new Student(2l, "Serik", "Berikov", 92, "A"));
        students.add(new Student(3l, "John", "Doe", 41, "F"));
        students.add(new Student(4l, "Jey", "Lo", 53, "D"));
        students.add(new Student(5l, "Ilyas", "Ahmetov", 81, "B"));
    }

    private static Long id = 6l;

    public static List<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudentById(Long id){
        for(Student s: students){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
}
