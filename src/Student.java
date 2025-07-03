import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private int grade;
    private int studentId;
    private final ArrayList<Course> courses;

    public Student(String name, int age, String email, int grade, int studentId) throws IllegalArgumentException {
        super(name, age, email);
        this.grade = grade;
        this.studentId = studentId;
        courses = new ArrayList<>(5);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void addCourse(Course course) throws IllegalArgumentException {
        if (course == null) {
            throw new IllegalArgumentException("Course is required");
        }
        if (this.courses.size() >= 5) {
            throw new IllegalArgumentException("Student is already registered to 5 courses.");
        }
        courses.add(course);
    }
}
