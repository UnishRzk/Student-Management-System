import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        studentList.add(student);
        System.out.println("Student added Sucessfully");
    }

    public void displayAllStudents(){
        if (studentList.isEmpty()){
            System.out.println("No data found!");
            return;
        }

        for (Student s: studentList){
            System.out.println(s);
        }
    }

    public Student findById(String id){
        for (Student s: studentList){
            if (s.getId().equalsIgnoreCase(id)){
                return s;
            }
        }
        return null;
    }

    public void removeStudent(String id){
        Student student = findById(id);
        if (student != null){
            studentList.remove(student);
            System.out.println("Student Removed Sucessfully");
            return;
        }
        System.out.println("Student not found");
    }

    public void updateStudent(String id, String newName, int newAge, double newGpa) {
        Student student = findById(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            student.setGpa(newGpa);
            System.out.println("Student updated successfully.");
            return;
        }
        System.out.println("Student not found.");
    }


}
