import java.util.ArrayList;

public class Teacher extends Person{
    private int teacherId;
    private String subject;
    private final ArrayList<Course> courses;

    public Teacher(String name, int age, String email, int teacherId, String subject) throws IllegalArgumentException{
        super(name, age, email);
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject is required.");
        }
        this.teacherId = teacherId;
        this.subject = subject;
        courses = new ArrayList<>(3);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject is required.");
        }
        this.subject = subject;
    }

    public void addCourse(Course course) throws IllegalArgumentException {
        if (course == null) {
            throw new IllegalArgumentException("Course is required");
        }
        if (this.courses.size() >= 3) {
            throw new IllegalArgumentException("Teacher is already registered to 3 courses.");
        }
        courses.add(course);
    }
}
