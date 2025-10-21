public class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        System.out.println("Mentor support added.");
    }
}



