import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String question;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizApp {
    private ArrayList<Question> questions;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Add your questions here
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("A. Option 1");
        options1.add("B. Option 2");
        options1.add("C. Option 3");
        options1.add("D. Option 4");
        questions.add(new Question("What is 2 + 2?", options1, 3));

        // Add more questions as needed
    }

    public void startQuiz() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (Question question : questions) {
                System.out.println(question.getQuestion());

                for (String option : question.getOptions()) {
                    System.out.println(option);
                }

                System.out.print("Enter your choice (A, B, C, or D): ");
                String userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals(String.valueOf((char) ('A' + question.getCorrectOption())))) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + (char) ('A' + question.getCorrectOption()) + ".\n");
                }
            }
        }

        System.out.println("Quiz complete. Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.startQuiz();
    }
}