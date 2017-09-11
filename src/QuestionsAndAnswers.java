package src;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAndAnswers {

    private final String question1 = "Is this an urgent message? (Y)es/(N)o";
    private final String question2 = "Is this a formal message? (Y)es/(No)";
    private final String question3 = "Is this an important message (Y)es/(No)";

    private final List<String> questions = initQuestionsList();

    private final String answerIfYes1 = "These keywords might be helpful for you:" +
            "\n" + "-urgent" + "\n" + "-fast" + "\n" + "-yesterday" + "\n" +
            "-today" + "\n" + "-ASAP" + "\n" + "-immediately";
    private final String answerIfYes2 = "These keywords might be helpful for you:" +
            "\n" + "-good morning" + "\n" + "-dear" + "\n" + "-sir" +
            "\n" + "-madam" + "\n" + "-faithfully" + "\n" + "-sincerely";
    private final String answerIfYes3 = "These keywords might be helpful for you:" +
            "\n" + "-crucial" + "\n" + "-essential" + "\n" + "-important" +
            "\n" + "-vital" + "\n" + "-mandatory";

    private final List<String> listOfAnswersIfYes = initListOfAnswersIfYes();

    private final String answerIfNo1 = "These keywords might be helpful for you:" +
            "\n" + "-irrelevant" + "\n" + "-next" + "\n" + "-tomorrow" + "\n" + "-later";
    private final String answerIfNo2 = "These keywords might be helpful for you:" +
            "\n" + "-bye" + "\n" + "-hi" + "\n" + "-thx" + "\n" + "-peace out";
    private final String answerIfNo3 = "These keywords might be helpful for you:" +
            "\n" + "-moment" + "\n" +"-leisure"+ "\n" +"-btw";

    private final List<String> listOfAnswersIfNo = initListOfAnswersIfNo();


    private final List<String> initQuestionsList() {
        List<String> question = new ArrayList <>();
        question.add(question1);
        question.add(question2);
        question.add(question3);
        return question;
    }


    private  final List<String> initListOfAnswersIfYes() {
        List<String> answerIfYes = new ArrayList <>();
        answerIfYes.add(answerIfYes1);
        answerIfYes.add(answerIfYes2);
        answerIfYes.add(answerIfYes3);
        return answerIfYes;
    }


    private final List<String> initListOfAnswersIfNo() {
        List<String> answerIfNo = new ArrayList <>();
        answerIfNo.add(answerIfNo1);
        answerIfNo.add(answerIfNo2);
        answerIfNo.add(answerIfNo3);
        return answerIfNo;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getListOfAnswersIfYes() {
        return listOfAnswersIfYes;
    }

    public List<String> getListOfAnswersIfNo() {
        return listOfAnswersIfNo;
    }
}
