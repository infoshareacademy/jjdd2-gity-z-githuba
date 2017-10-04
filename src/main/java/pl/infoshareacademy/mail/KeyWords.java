package pl.infoshareacademy.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeyWords {


    public List<String> getKeywordsList() {
        return keywordsList;
    }

    List<String> keywordsList = new ArrayList<>();
    List<String> keywordsSelected = new ArrayList<>();


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
                    keywordsSelected.add(String.valueOf(question.getListOfAnswersIfNo().get(i)));
                    break;
            }
        }
        System.out.println();
        System.out.println(keywordsSelected);
        keywordsList.addAll(keywordsSelected);
        System.out.println(keywordsList);
        keywordsList.forEach(System.out::println);
        System.out.println("Have a nice day!");
        }

    }