import java.util.HashMap;
import java.util.Map;

public class StudentPortalFacade {
    private Map<String, Course> enrolledCourses = new HashMap<>();
    private Map<String, String> progress = new HashMap<>();

    public void enrollStudent(Student student, Course course) {
        student.enroll(course);
        enrolledCourses.put(course.getDescription(), course);
        progress.put(course.getDescription(), "Enrolled");
    }

    public void startLearning(Student student, Course course) {
        if (enrolledCourses.containsKey(course.getDescription())) {
            student.startLearning(course);
            progress.put(course.getDescription(), "Learning Started");
        }
    }

    public void completeCourse(Student student, Course course) {
        if (enrolledCourses.containsKey(course.getDescription())) {
            student.completeCourse(course);
            progress.put(course.getDescription(), "Completed");
        }
    }

    public void getCourseProgress(String courseDescription) {
        System.out.println(courseDescription + " Progress: " + progress.get(courseDescription));
    }
}


