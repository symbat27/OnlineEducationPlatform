public class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " + Mentor support included.";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (With Mentor Support)";
    }
}


