package inheritance.class_problems;

abstract class Question {

    protected int marks;

    public Question(int marks) {
        this.marks = marks;
    }

    public abstract int grade(String answer);
}

class MCQQuestion extends Question {

    private String correctAnswer;

    public MCQQuestion(int marks, String correctAnswer) {
        super(marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int grade(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return marks;
        }

        return 0;
    }
}

class TFQuestion extends Question {

    private String correctAnswer;

    public TFQuestion(int marks, String correctAnswer) {
        super(marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int grade(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return marks;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    private String[] keywords;

    public EssayQuestion(int marks, String[] keywords) {
        super(marks);
        this.keywords = keywords;
    }

    @Override
    public int grade(String answer) {

        int matches = 0;

        String lowerAnswer = answer.toLowerCase();

        for (String keyword : keywords) {
            if (lowerAnswer.contains(keyword.toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return (marks * 75) / 100;
        }
        else if (matches == 1) {
            return (marks * 50) / 100;
        }
        else {
            return 0;
        }
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Question[] questions = {
            new MCQQuestion(10, "A"),
            new TFQuestion(10, "true"),
            new EssayQuestion(
                20,
                new String[]{"inheritance", "polymorphism"}
            )
        };

        String[] answers = {
            "A",
            "TRUE",
            "Inheritance and polymorphism are important OOP concepts."
        };

        int totalScore = 0;

        for (int i = 0; i < questions.length; i++) {

            int score = questions[i].grade(answers[i]);

            System.out.println("Question " + (i + 1) + ": " + score);

            totalScore += score;
        }

        System.out.println("Total Score: " + totalScore);
    }
}