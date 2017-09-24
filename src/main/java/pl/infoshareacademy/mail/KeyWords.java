package pl.infoshareacademy.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.Key;
import java.util.Scanner;

public class KeyWords {

    private static final Logger logger = LogManager.getLogger(KeyWords.class.getName());

    private Scanner scanner = new Scanner(System.in);

    private String getUserInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public void KeyWordsIdentification() {
        QuestionsAndAnswers question = new QuestionsAndAnswers();

        for (int i = 0; i < question.getQuestions().size(); i++) {
            System.out.println();
            System.out.println(question.getQuestions().get(i));
            String wyborUzytkownika = getUserInput();

            while (!(wyborUzytkownika.equals("y") || wyborUzytkownika.equals("n"))) {
                logger.warn("Question #" + (i + 1) + ". Input mismatch! Expected Y or N got other value!");
                System.out.println("Please enter (Y)es or (N)o");
                wyborUzytkownika = scanner.nextLine().toLowerCase();
            }
            switch (wyborUzytkownika) {
                case "y":
                    logger.info("User answered Yes to the question #" + (i + 1));
                    System.out.println();
                    System.out.println("These keywords might be helpful for you:");
                    System.out.println(question.getListOfAnswersIfYes().get(i));
                    break;
                case "n":
                    logger.info("User answered No to the question #" + (i + 1));
                    System.out.println();
                    System.out.println("These keywords might be helpful for you:");
                    System.out.println(question.getListOfAnswersIfNo().get(i));
                    break;
            }
        }
        System.out.println();
        System.out.println("Have a nice day!");
        }
    }