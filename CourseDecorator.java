public abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course course) {
        this.decoratedCourse = course;
    }

    @Override
    public String deliverContent() {
        return decoratedCourse.deliverContent();
    }

    @Override
    public String getDescription() {
        return decoratedCourse.getDescription();
    }
}

