public class StudentPortalFacade {

    public void enrollInCourse(Student student, Course course) {
        System.out.println(student.getClass().getSimpleName() + " " + student.name + " enrolled in course.");
    }

    public void completeCourse(Student student, Course course, int points) {
        System.out.println(student.name + " has completed the course!");
        student.addCourseToHistory(course.getClass().getSimpleName(), points);
        System.out.println("Course History:\n" + student.getCourseHistory());
    }
}



