import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
    private ArrayList<String> courses;
    private double gpa;

    // constructors

    public Student() {
    }

    public Student(String id, String name, int age, ArrayList<String> courses, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
        this.gpa = gpa;
    }

    // getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public double getGpa() {
        return gpa;
    }

    // setters


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // to String


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                ", gpa=" + gpa +
                '}';
    }
}
