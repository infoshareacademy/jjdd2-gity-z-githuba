package pl.infoshareacademy.mail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Please enter ABSOLUTE path to e-mail to analyze: ");
        System.out.println("Example: /home/user/mail.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        int splitCounter = 0;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String buffor = br.readLine();
            while (buffor != null){
                if (buffor.contains("@") || (buffor.matches("[0-9+]+")) && buffor.length() == 9){
                    splitCounter++;
                    _split(buffor, splitCounter);
                }
                buffor = br.readLine();
            } br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        loadMailToCollection("/home/sowatheking/test.txt");
    }

    public static void _split(String string, int splitCounter){
        String result_spl[] = string.split(" ");
        for (int i = 0; i < result_spl.length; i++){
            if (result_spl[i].contains("@") || result_spl[i].matches("[0-9+]+")){
                System.out.println("Split complete!  Returned: " + result_spl[i]);
            }
        }
    }

    public static ArrayList<String> loadMailToCollection(String path){
        int i = 0;
        try {
            ArrayList<String> mailContent = new ArrayList<String>();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String buffor = br.readLine();
            while (buffor != null){
                i++;
                mailContent.add(buffor);
                buffor = br.readLine();
            }
            System.out.println("Załadowano plik do pamięci! " + i + " Lini załadowane!");
            br.close();
            return mailContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
