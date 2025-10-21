public abstract class Student {
    protected String id;
    protected String name;
    protected String courseHistory = "";

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void study();

    public void addCourseToHistory(String courseName, int points) {
        this.courseHistory += courseName + " - Points: " + points + "\n";
    }


    public String getCourseHistory() {
        return this.courseHistory;
    }

    public String getId() {
        return this.id;
    }
}



