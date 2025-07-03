public class Course {
    private String courseName;
    private int courseId;

    public Course(String courseName, int courseId) throws IllegalArgumentException {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name is required.");
        }
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) throws IllegalArgumentException {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name is required.");
        }
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
