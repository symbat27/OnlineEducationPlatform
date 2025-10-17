public class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " + Gamification elements: points, leaderboard.";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (With Gamification)";
    }
}


