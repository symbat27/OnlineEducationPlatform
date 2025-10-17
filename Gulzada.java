public class Gulzada extends Student {

    public Gulzada(String name) {
        super(name);
    }

    @Override
    public void enroll(Course course) {
        System.out.println(name + " enrolled in " + course.getDescription());
    }

    @Override
    public void startLearning(Course course) {
        System.out.println(name + " started learning " + course.getDescription() + " with Gamification");
    }

    @Override
    public void completeCourse(Course course) {
        System.out.println(name + " completed " + course.getDescription() + " with Gamification and earned a Certificate");
    }
}





