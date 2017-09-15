package pl.infoshareacademy.mail;

import java.util.Scanner;

public class KeyWords {

    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public static void main(String[] args) {
        QuestionsAndAnswers question = new QuestionsAndAnswers();

        for (int i = 0; i < question.getQuestions().size(); i++) {
            System.out.println();
            System.out.println(question.getQuestions().get(i));
            String wyborUzytkownika;
            wyborUzytkownika = getUserInput();
            while (!(wyborUzytkownika.equals("y") || wyborUzytkownika.equals("n"))) {
                System.out.println("Please enter (Y)es or (N)o");
                wyborUzytkownika = scanner.nextLine().toLowerCase();
            }
            switch (wyborUzytkownika) {
                case "y":
                    System.out.println();
                    System.out.println(question.getListOfAnswersIfYes().get(i));
                    break;
                case "n":
                    System.out.println();
                    System.out.println(question.getListOfAnswersIfNo().get(i));
                    break;
            }
        }

        System.out.println();
        System.out.println("Have a nice day!");
        }
    }