public class Symbat extends Student {

    public Symbat(String name) {
        super(name);
    }

    @Override
    public void enroll(Course course) {
        System.out.println(name + " enrolled in " + course.getDescription() + " (With Certificate) (With Mentor Support)");
    }

    @Override
    public void startLearning(Course course) {
        System.out.println(name + " started learning " + course.getDescription() + " with Mentor Support");
    }

    @Override
    public void completeCourse(Course course) {
        System.out.println(name + " completed " + course.getDescription() + " with Mentor Support and earned a Certificate");
    }
}




