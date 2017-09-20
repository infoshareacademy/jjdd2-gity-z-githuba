package pl.infoshareacademy.mail;
import java.util.ArrayList;

public class Menu {
    public static void PrintMenu(){
        System.out.println("Welcome @User! How i can help you?");
        System.out.println("");
        System.out.format("%-60s - AVALIBLE%n","1. What keywords should i use to find mine email?");
        System.out.format("%-60s - AVALIBLE%n","2. Analyze contact data from mine e-mail");
        System.out.format("%-60s - UNAVALIBLE%n","3. Show me mine top 10 customer's");
        System.out.format("%-60s - AVALIBLE%n","4. Filter mine contact's (Single .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","5. Filter mine contact's (Multiple .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","6. Show me abandoned customers");
        System.out.println();
        System.out.println("0. Quit");
    } // Function that prints menu on the screen

    public static void PrintMenuKeywords() {
        Messenger msg = new Messenger();
        msg.warningErrorReport("Function not done yet!");
    }

    public static void PrintMenuAnalyze(){
        Messenger msg = new Messenger();
        msg.warningErrorReport("Function not done yet!");
    }

    public static void filterMaches(boolean mail, boolean phone, ArrayList<String> mailContent){
        for (int i = 0; i < mailContent.size(); i++){
            if (mailContent.get(i).contains("@")) {
                System.out.println("Znaleziono dopasowanie! " + mailContent.get(i));
                String[] splitResult = mailContent.get(i).split(" ");
                for (int j = 0; j < splitResult.length; j++){
                }
            } else if (mailContent.get(i).matches("[0-9+]+")){
                System.out.println("Znaleziono numer! " + mailContent.get(i));
            }
        }
    }
}
