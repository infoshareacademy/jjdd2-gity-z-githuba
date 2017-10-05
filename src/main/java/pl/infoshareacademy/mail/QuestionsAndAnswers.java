package pl.infoshareacademy.mail;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAndAnswers {

    private final List<String> questions = getQuestionsList();
    private final List<List<String>> listOfAnswersIfYes = initListOfAnswersIfYes();
    private final List<List<String>> listOfAnswersIfNo = initListOfAnswersIfNo();

    private final List<String> getQuestionsList() {
        String question1 = "Is this an urgent message? Y/N";
        String question2 = "Is this a formal message? Y/N";
        String question3 = "Is this an important message Y/N";
        List<String> question = new ArrayList <>();
        question.add(question1);
        question.add(question2);
        question.add(question3);
        return question;
    }

    private List<List<String>> initListOfAnswersIfYes() {
        List<String> answerIfYes1 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi twierdzącej na pytanie 1
        answerIfYes1.add("urgent");
        answerIfYes1.add("fast");
        answerIfYes1.add("yesterday");
        answerIfYes1.add("today");
        answerIfYes1.add("ASAP");
        answerIfYes1.add("immediately");
        List<String> answerIfYes2 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi twierdzącej na pytanie 2
        answerIfYes2.add("good morning");
        answerIfYes2.add("dear");
        answerIfYes2.add("sir");
        answerIfYes2.add("madam");
        answerIfYes2.add("faithfully");
        answerIfYes2.add("sincerely");
        List<String> answerIfYes3 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi twierdzącej na pytanie 3
        answerIfYes3.add("crucial");
        answerIfYes3.add("essential");
        answerIfYes3.add("important");
        answerIfYes3.add("vital");
        answerIfYes3.add("mandatory");
        List<List<String>> answerIfYes = new ArrayList <>();
        answerIfYes.add(answerIfYes1); //zwraca listę słów kluczowych jeśli odp na pytanie 1 jest twierdząca
        answerIfYes.add(answerIfYes2); //zwraca listę słów kluczowych jeśli odp na pytanie 2 jest twierdząca
        answerIfYes.add(answerIfYes3); //zwraca listę słów kluczowych jeśli odp na pytanie 3 jest twierdząca
        return answerIfYes;
    }

    private List<List<String>> initListOfAnswersIfNo() {
        List<String> answerIfNo1 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi przeczącej na pytanie 1
        answerIfNo1.add("irrelevant");
        answerIfNo1.add("next");
        answerIfNo1.add("tomorrow");
        answerIfNo1.add("later");
        List<String> answerIfNo2 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi przeczącej na pytanie 2
        answerIfNo2.add("bye");
        answerIfNo2.add("hi");
        answerIfNo2.add("thx");
        answerIfNo2.add("peace out");
        List<String> answerIfNo3 = new ArrayList<>(); //lista słów kluczowych dla odpowiedzi przeczącej na pytanie 3
        answerIfNo3.add("moment");
        answerIfNo3.add("leisure");
        answerIfNo3.add("btw");
        answerIfNo3.add("nevermind");
        List<List<String>> answerIfNo = new ArrayList <>();
        answerIfNo.add(answerIfNo1); //zwraca listę słów kluczowych jeśli odp na pytanie 1 jest przecząca
        answerIfNo.add(answerIfNo2); //zwraca listę słów kluczowych jeśli odp na pytanie 2 jest przecząca
        answerIfNo.add(answerIfNo3); //zwraca listę słów kluczowych jeśli odp na pytanie 3 jest przecząca
        return answerIfNo;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<List<String>> getListOfAnswersIfYes() {
        return listOfAnswersIfYes;
    }

    public List<List<String>> getListOfAnswersIfNo() {
        return listOfAnswersIfNo;
    }
}
