package src;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAndAnswers {

    private String question1 = "Czy email jest pilny? (T)ak/(N)ie";
    private String question2 = "Czy jest to email służbowy? (T)ak/(N)ie";
    private String question3 = "Czy ten email jest ważny? (T)ak/(N)ie";
    private List<String> question;

    public String listOfQuestions(int x) {
        question = new ArrayList <String>();
        question.add(question1);
        question.add(question2);
        question.add(question3);
        return question.get(x);
    }

    public List<String> getQuestion() {
        return question;
    }

    private String answerIfYes1 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-pilny" + "\n" + "-szybko" + "\n" + "-wczoraj" + "\n" +
            "-dzisiaj" + "\n" + "-ASAP" + "\n" + "-bezzwłocznie";
    private String answerIfYes2 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-dzień dobry" + "\n" + "-witam" + "\n" + "-pozdrawiam" +
            "\n" + "-żegnam" + "\n" + "-do widzenia";
    private String answerIfYes3 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-ważne" + "\n" + "-istotne" + "\n" + "-koniecznie" +
            "\n" + "-obowiazkowo" + "\n" + "-obligatoryjnie";
    private List<String> answerIfYes;

    public String listOfAnswersIfYes(int x) {
        List<String> answerIfYes = new ArrayList <String>();
        answerIfYes.add(answerIfYes1);
        answerIfYes.add(answerIfYes2);
        answerIfYes.add(answerIfYes3);
        return answerIfYes.get(x);
    }

    public List<String> getAnswerIfYes() {
        return answerIfYes;
    }

    private String answerIfNo1 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-nieważne" + "\n" + "-dawno" + "\n" + "-jutro" + "\n" + "-później";
    private String answerIfNo2 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-cześć" + "\n" + "-hej" + "\n" + "-dzięki" + "\n" + "-na razie";
    private String answerIfNo3 = "Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
            "\n" + "-nieważne" + "\n" +"-nieistotne"+ "\n" +"-btw"+ "\n" +"-przy okazji";
    private List<String> answerIfNo;

    public String listOfAnswersIfNo(int x) {
        List<String> answerIfNo = new ArrayList <String>();
        answerIfNo.add(answerIfNo1);
        answerIfNo.add(answerIfNo2);
        answerIfNo.add(answerIfNo3);
        return answerIfNo.get(x);
    }

    public List<String> getAnswerIfNo() {
        return answerIfNo;
    }
}
