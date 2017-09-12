package src;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAndAnswers {

    private final List<String> questions = initQuestionsList();
    private final List<String> listOfAnswersIfYes = initListOfAnswersIfYes();
    private final List<String> listOfAnswersIfNo = initListOfAnswersIfNo();


    private final List<String> initQuestionsList() {
        String question1 = "Is this an urgent message? (Y)es/(N)o";
        String question2 = "Is this a formal message? (Y)es/(No)";
        String question3 = "Is this an important message (Y)es/(No)";
        List<String> question = new ArrayList <>();
        question.add(question1);
        question.add(question2);
        question.add(question3);
        return question;
    }

    private  final List<String> initListOfAnswersIfYes() {
        ArrayList<String> answerIfYes1 = new ArrayList<>();
        answerIfYes1.add("urgent");
        answerIfYes1.add("fast");
        answerIfYes1.add("yesterday");
        answerIfYes1.add("today");
        answerIfYes1.add("ASAP");
        answerIfYes1.add("immediately");
        String answerIfYes2 = "-good morning\n-dear\n-sir\n-madam\n-faithfully\n-sincerely";
        String answerIfYes3 = "-crucial\n-essential\n-important\n-vital\n-mandatory";
        List<String> answerIfYes = new ArrayList <>();
        answerIfYes.add(String.valueOf(answerIfYes1));
        answerIfYes.add(answerIfYes2);
        answerIfYes.add(answerIfYes3);
        return answerIfYes;
    }


    private final List<String> initListOfAnswersIfNo() {
        String answerIfNo1 = "-irrelevant\n-next\n-tomorrow\n-later";
        String answerIfNo2 = "-bye\n-hi\n-thx\n-peace out";
        String answerIfNo3 = "-moment\n-leisure\n-btw";
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
