package pl.infoshareacademy.mail;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyWords {

    private List<String> keywordsSelected = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private String getUserInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public List KeyWordsIdentification() {

        QuestionsAndAnswers question = new QuestionsAndAnswers();

        for (int i = 0; i < question.getQuestions().size(); i++) {
            System.out.println();
            System.out.println(question.getQuestions().get(i));
            String wyborUzytkownika = getUserInput();

            while (!(wyborUzytkownika.equals("y") || wyborUzytkownika.equals("n"))) {
                System.out.println("Please enter (Y)es or (N)o");
                wyborUzytkownika = scanner.nextLine().toLowerCase();
            }
            switch (wyborUzytkownika) {
                case "y":
                    System.out.println();
                    System.out.println("These keywords might be helpful for you:");
                    System.out.println(question.getListOfAnswersIfYes().get(i));
                    keywordsSelected.addAll(question.getListOfAnswersIfYes().get(i));
                    break;
                case "n":
                    System.out.println();
                    System.out.println("These keywords might be helpful for you:");
                    System.out.println(question.getListOfAnswersIfNo().get(i));
                    keywordsSelected.addAll(question.getListOfAnswersIfNo().get(i));
                    break;
            }
        }
        System.out.println();
        System.out.println("Have a nice day!\n");
        return keywordsSelected;
        }
    }
