import java.io.*;
import java.util.*;

public class FileStorage {

    private static final String STUDENT_FILE = "students.txt";
    private static final String COURSE_FILE = "courses.txt";
    private static final String HISTORY_FILE = "history.txt";
    private static final String CERTIFICATES_FILE = "certificates.txt";
    private static final String FINAL_EXAM_RESULTS_FILE = "final_exam_results.txt";

    public static void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE))) {
            for (Student s : students) {
                writer.write(s.getClass().getSimpleName() + ":" + s.name + ":" + s.getId());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return students;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 3) {  // Ensures that we have type, name and id
                    String type = parts[0];
                    String name = parts[1];
                    String id = parts[2];

                    StudentFactory factory;
                    switch (type) {
                        case "SecondYearStudent":
                            factory = new SecondYearFactory();
                            break;
                        case "ThirdYearStudent":
                            factory = new ThirdYearFactory();
                            break;
                        default:
                            factory = new FirstYearFactory();
                    }

                    students.add(factory.createStudent(name, id));  // Создаём студента с ID
                } else {
                    System.out.println("Invalid data format in student file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }

        return students;
    }

    public static void saveCourses(List<String> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COURSE_FILE))) {
            for (String c : courses) {
                writer.write(c);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public static List<String> loadCourses() {
        List<String> courses = new ArrayList<>();
        File file = new File(COURSE_FILE);
        if (!file.exists()) return courses;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name;
            while ((name = reader.readLine()) != null) {
                courses.add(name);
            }
        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }

        return courses;
    }

    public static void saveHistory(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(student.name + ":\n" + student.getCourseHistory() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    public static void showHistory() {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) {
            System.out.println("No learning history yet.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n Learning History:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading history: " + e.getMessage());
        }
    }

    public static void saveCertificates(List<Certificate> certificates) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CERTIFICATES_FILE, true))) {
            for (Certificate certificate : certificates) {
                writer.write(certificate.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving certificates: " + e.getMessage());
        }
    }

    public static void saveFinalExamResults(String studentId, String courseName, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FINAL_EXAM_RESULTS_FILE, true))) {
            writer.write("Student ID: " + studentId + ", Course: " + courseName + ", Final Exam Score: " + score);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving final exam results: " + e.getMessage());
        }
    }

    public static List<Certificate> loadCertificates() {
        List<Certificate> certificates = new ArrayList<>();
        File file = new File(CERTIFICATES_FILE);
        if (!file.exists()) return certificates;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\n");
                if (parts.length >= 3) {
                    String studentName = parts[1].split(": ")[1];
                    String studentId = parts[2].split(": ")[1];
                    String courseName = parts[3].split(": ")[1];

                    certificates.add(new Certificate(studentName, studentId, courseName));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading certificates: " + e.getMessage());
        }

        return certificates;
    }

    public static List<String> loadFinalExamResults() {
        List<String> results = new ArrayList<>();
        File file = new File(FINAL_EXAM_RESULTS_FILE);
        if (!file.exists()) return results;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading final exam results: " + e.getMessage());
        }

        return results;
    }
}



