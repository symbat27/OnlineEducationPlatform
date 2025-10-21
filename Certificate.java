import java.util.UUID;

public class Certificate {
    private String id;
    private String studentName;
    private String studentId;
    private String courseName;

    public Certificate(String studentName, String studentId, String courseName) {
        this.id = UUID.randomUUID().toString();
        this.studentName = studentName;
        this.studentId = studentId;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Certificate ID: " + id + "\nStudent: " + studentName + "\nStudent ID: " + studentId + "\nCourse: " + courseName;
    }
}

