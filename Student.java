public abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract void enroll(Course course);
    public abstract void startLearning(Course course);
    public abstract void completeCourse(Course course);
}


