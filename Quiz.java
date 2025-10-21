
import java.util.*;

public class Quiz {
    private String courseName;
    private Map<String, String[]> questions;
    private Map<String, String> correctAnswers;

    public Quiz(String courseName) {
        this.courseName = courseName;
        this.questions = new HashMap<>();
        this.correctAnswers = new HashMap<>();

        addQuestion("What is 1 + 1?", new String[] {"1", "2", "3"}, "2");
        addQuestion("What is 2 + 2?", new String[] {"3", "4", "5"}, "4");
        addQuestion("What is 3 + 3?", new String[] {"5", "6", "7"}, "6");
    }

    public void addQuestion(String question, String[] options, String correctAnswer) {
        questions.put(question, options);
        correctAnswers.put(question, correctAnswer);
    }

    public int takeQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\n Quiz for " + courseName + " course");
        for (Map.Entry<String, String[]> entry : questions.entrySet()) {
            String question = entry.getKey();
            String[] options = entry.getValue();

            System.out.println("\n" + question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Your answer (1-" + options.length + "): ");
            int answer = Integer.parseInt(sc.nextLine());

            if (options[answer - 1].equals(correctAnswers.get(question))) {
                score++;
            }
        }

        return score;
    }
}


