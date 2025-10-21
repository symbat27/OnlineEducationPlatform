import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackSystem {

    private static final String FEEDBACK_FILE = "feedback.txt";

    public static void saveFeedback(Feedback feedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FEEDBACK_FILE, true))) {
            writer.write(feedback.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
        }
    }

    public static List<Feedback> loadFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        File file = new File(FEEDBACK_FILE);

        if (!file.exists()) return feedbackList;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String courseName = line.split("\n")[0].split(": ")[1];
                String ratingLine = reader.readLine();
                int rating = Integer.parseInt(ratingLine.split(": ")[1]);
                String feedbackText = reader.readLine().split(": ")[1];
                feedbackList.add(new Feedback(courseName, feedbackText, rating));
            }
        } catch (IOException e) {
            System.out.println("Error loading feedback: " + e.getMessage());
        }
        return feedbackList;
    }
}

