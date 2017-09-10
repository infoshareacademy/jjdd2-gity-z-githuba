import src.QuestionsAndAnswers;

import java.util.List;
import java.util.Scanner;

public class KeyWords {

    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public static void main(String[] args) {
        QuestionsAndAnswers question = new QuestionsAndAnswers();

        for (int i = 0; i < 3; i++){
            System.out.println();
            System.out.println(question.listOfQuestions(i));
            String wyborUzytkownika;
            wyborUzytkownika = getUserInput();
            while (!(wyborUzytkownika.equals("t") || wyborUzytkownika.equals("n"))) {
                System.out.println("Wpisz (T)ak lub (N)ie");
                wyborUzytkownika = scanner.nextLine().toLowerCase();
            }
            switch (wyborUzytkownika) {
                case "t":
                    System.out.println();
                    System.out.println(question.listOfAnswersIfYes(i));
                    break;
                case "n":
                    System.out.println();
                    System.out.println(question.listOfAnswersIfNo(i));
                    break;
            }
        }

        System.out.println();
        System.out.println("Cieszę się, żę mogłem pomóc!");
    }
}
