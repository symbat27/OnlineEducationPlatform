public class Feedback {
    private String courseName;
    private String feedbackText;
    private int rating;

    public Feedback(String courseName, String feedbackText, int rating) {
        this.courseName = courseName;
        this.feedbackText = feedbackText;
        this.rating = rating;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + "\nRating: " + rating + "\nFeedback: " + feedbackText;
    }
}

