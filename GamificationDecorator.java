import java.util.Random;

public class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        int points = new Random().nextInt(100) + 1;
        System.out.println("Gamification enabled! " + points + " points earned.");
    }
}


