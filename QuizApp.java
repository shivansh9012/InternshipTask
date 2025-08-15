
import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            " On which day is the Bihar Diwas celebrated?",
            new String[]{"20 January", "22 March", "23 June", "15 August"},
            2
        ));
        questions.add(new Question(
            "What is the capital of Bihar?",
            new String[]{"Patna", "Purnia", " Darbhanga", "Munger"},
            1
        ));
        questions.add(new Question(
            "What is the official language of Bihar?",
            new String[]{"Hindi and Urdu", "Sanskrit and Urdu", "Hindi and Sanskrit", " none of these"},
            1
        ));
        questions.add(new Question(
            "Which is the state tree of Bihar?",
            new String[]{"Bell", "Peepal", " Mango", "Neem"},
            2
        ));
        questions.add(new Question(
            "What is the state animal of Bihar?",
            new String[]{"Cow", "Bull", "Buffalo", " horse"},
            2
        ));
        questions.add(new Question(
            "Which is the state bird of Bihar?",
            new String[]{"Swan", " hen", "Cuckoo", "Sparrow"},
            4
        ));
        questions.add(new Question(
            "Which is the district with the lowest sex ratio in Bihar?",
            new String[]{"Munger", "Saharsa", "Aurangabad", "Madhepura"},
            1
        ));

        int score = 0;

        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.question);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }
            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();

            if (answer == q.correctAnswer) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is: " + q.options[q.correctAnswer - 1]);
            }
        }

        
        System.out.println("\n🎯 Your final score is: " + score + "/" + questions.size());
       
    }
}
