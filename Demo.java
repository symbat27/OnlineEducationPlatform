import java.util.*;

public class Demo {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentPortalFacade portal = new StudentPortalFacade();

    private static final List<Student> students = FileStorage.loadStudents();
    private static final List<String> courses = FileStorage.loadCourses();

    public static void main(String[] args) {
        System.out.println("Welcome to Online Education Platform");

        if (courses.isEmpty()) {
            courses.add("Calculus");
            courses.add("Web Technologies");
            courses.add("Design");
            FileStorage.saveCourses(courses);
        }

        while (true) {
            System.out.println("\n MAIN MENU:");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Feedback");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    studentMenu();
                    break;
                case "2":
                    courseMenu();
                    break;
                case "3":
                    feedbackMenu();
                    break;
                case "4":
                case "exit":
                    System.out.println("Goodbye!");
                    FileStorage.saveStudents(students);
                    FileStorage.saveCourses(courses);
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void studentMenu() {
        while (true) {
            System.out.println("\n STUDENTS MENU:");
            System.out.println("1. Register new student");
            System.out.println("2. View all students");
            System.out.println("3. Back to main menu");
            System.out.print("Choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    registerStudent();
                    break;
                case "2":
                    viewStudents();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void registerStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        System.out.print("Choose student type (first/second/third): ");
        String type = sc.nextLine();

        StudentFactory factory;
        if (type.equalsIgnoreCase("second")) {
            factory = new SecondYearFactory();
        } else if (type.equalsIgnoreCase("third")) {
            factory = new ThirdYearFactory();
        } else {
            factory = new FirstYearFactory();
        }

        Student student = factory.createStudent(name, id);
        students.add(student);
        FileStorage.saveStudents(students);
        System.out.println(name + " registered as " + type + "-year student!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("\n Registered Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getClass().getSimpleName() + " - " + students.get(i).name + " (ID: " + students.get(i).getId() + ")");
        }
    }

    private static void courseMenu() {
        while (true) {
            System.out.println("\n COURSES MENU:");
            System.out.println("1. View available courses");
            System.out.println("2. Enroll course");
            System.out.println("3. Finish course (final exam)");
            System.out.println("4. Back to main menu");
            System.out.print("Choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    viewCourses();
                    break;
                case "2":
                    enrollCourse();
                    break;
                case "3":
                    finishCourse();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void viewCourses() {
        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }

    private static void enrollCourse() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\nSelect student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).name);
        }
        System.out.print("Enter student number: ");
        int sIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (sIndex < 0 || sIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }

        System.out.println("\nAvailable courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        System.out.print("Enter course number: ");
        int cIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (cIndex < 0 || cIndex >= courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }

        String chosen = courses.get(cIndex);
        Course course;
        if (chosen.equalsIgnoreCase("Calculus")) {
            course = new CalculusCourse();
        } else if (chosen.equalsIgnoreCase("Web Technologies")) {
            course = new WebTechnologiesCourse();
        } else if (chosen.equalsIgnoreCase("Design")) {
            course = new DesignCourse();
        } else {
            course = () -> System.out.println("Studying " + chosen + "...");
        }

        System.out.print("Add Mentor Support? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            course = new MentorSupportDecorator(course);
        }

        System.out.print("Add Certificate? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            course = new CertificateDecorator(course);
        }

        System.out.print("Add Gamification? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            course = new GamificationDecorator(course);
        }

        Student student = students.get(sIndex);
        portal.enrollInCourse(student, course);
        portal.completeCourse(student, course, 85);
    }

    private static void finishCourse() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\nSelect student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).name);
        }
        System.out.print("Enter student number: ");
        int sIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (sIndex < 0 || sIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }

        System.out.println("\nSelect course to finish:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        System.out.print("Enter course number: ");
        int cIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (cIndex < 0 || cIndex >= courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }

        String chosenCourse = courses.get(cIndex);
        Quiz quiz = new Quiz(chosenCourse);
        quiz.addQuestion("What is 2 + 2?", new String[] {"3", "4", "5"}, "4");
        int score = quiz.takeQuiz();

        Certificate certificate = new Certificate(students.get(sIndex).name, students.get(sIndex).getId(), chosenCourse);
        List<Certificate> certificates = new ArrayList<>();
        certificates.add(certificate);
        FileStorage.saveCertificates(certificates);

        FileStorage.saveFinalExamResults(students.get(sIndex).getId(), chosenCourse, score);
    }

    private static void feedbackMenu() {
        while (true) {
            System.out.println("\n FEEDBACK MENU:");
            System.out.println("1. Leave feedback");
            System.out.println("2. View all feedback");
            System.out.println("3. Back to main menu");
            System.out.print("Choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    leaveFeedback();
                    break;
                case "2":
                    viewFeedback();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void leaveFeedback() {
        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();
        System.out.print("Enter your feedback: ");
        String feedbackText = sc.nextLine();
        System.out.print("Rate the course (1-5): ");
        int rating = Integer.parseInt(sc.nextLine());

        Feedback feedback = new Feedback(courseName, feedbackText, rating);
        FeedbackSystem.saveFeedback(feedback);
        System.out.println("Feedback saved successfully!");
    }

    private static void viewFeedback() {
        List<Feedback> feedbackList = FeedbackSystem.loadFeedback();
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }
}







