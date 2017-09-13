package com.company;

import com.company.Messenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void PrintMenu(){
        /*Zastosowane formatowanie stringów dla łatdniejszego wyglądu.
        %-60s oznacza zareserwowanie 60 znaków do lewej dla danego stringa. Pozwala to stworzyć swego rodzaju tebele.
        Przykładowy kod pozwalający lepiej to zrozumieć:
        List<String> listBook = Arrays.asList(
                "Head First Java",
                "Effective Java",
                "The Passionate Programmer",
                "Head First Design Patterns"
        );
        for (String book : listBook) {
            System.out.format("%-30s - In Stock%n", book);
        }*/

        System.out.println("Welcome @User! How i can help you?");
        System.out.println("");
        System.out.format("%-60s - AVALIBLE%n","1. What keywords should i use to find mine email?");
        System.out.format("%-60s - AVALIBLE%n","2. Analyze contact data from mine e-mail");
        System.out.format("%-60s - UNAVALIBLE%n","3. Show me mine top 10 customer's");
        System.out.format("%-60s - UNAVALIBLE%n","4. Filter mine contact's (Single .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","5. Filter mine contact's (Multiple .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","6. Show me abandoned customers");
        System.out.println();
        System.out.println("0. Quit");
    } // Function that prints menu on the screen

    public static void PrintMenuKeywords() {
        Messenger msg = new Messenger();
        /*Scanner scanner = new Scanner(System.in);
        System.out.format("%-60s%n", "1. Is this urgent correspondance?? (Y/N):");
        String answer1 = scanner.nextLine().toLowerCase();
        System.out.format("%-60s%n", "2. Is it private correspondence? (Y/N):");
        String answer2 = scanner.nextLine().toLowerCase();
        System.out.format("%-60s%n", "3. Is it bus" +
                "sines related correspondance? (Y/N):");
        String answer3 = scanner.nextLine().toLowerCase();
        String path = "/home/sowatheking/Database.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String buffor = br.readLine();
            while (buffor != null){
                if (buffor.contains("[Urgent]") && answer1.contains("y")){
                    buffor = br.readLine();
                    while (buffor != null || buffor.isEmpty()){
                        System.out.println(buffor);
                        buffor = br.readLine();
                    }
                }
                if (buffor.contains("[Private]") && answer2.contains("y")){
                    buffor = br.readLine();
                    while (buffor != null || buffor.isEmpty()){
                        System.out.println(buffor);
                        buffor = br.readLine();
                    }
                }
                if (buffor.contains("[Business]") && answer3.contains("y")){
                    buffor = br.readLine();
                    while (buffor != null || buffor.isEmpty()){
                        System.out.println(buffor);
                        buffor = br.readLine();
                    }
                }
                buffor = br.readLine();
            } br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer1 == "y") {
        }

        if (answer2 == "y") {
            // Odszukaj w pliku linie "[Private], wylistuj wszystko do pustej lini
        }

        if (answer3 == "y") {
            // Odszukaj w pliku linie "[Business], wylistuj wszystko do pustej lini
        }*/
        msg.criticalErrorRaport("Function not done yet!");
            }

    public static void PrintMenuAnalyze(){
        /*System.out.println("Please enter ABSOLUTE path to e-mail to analyze: ");
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

                    //TODO: Jeżeli 2 mache w jednej linijce, błędnie interpretuje counter

                }
                buffor = br.readLine();
            } br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        try {
            loadMailToCollection("/home/sowatheking/test.txt");
        } catch (IOException ex) {
            System.out.println("Nie mozna bylo zaladowac danych z powodu bledu.");
        }
        filterMaches(true, true, loadMailToCollection("/home/sowatheking/test.txt"));
    }
    public static void _split(String string, int splitCounter){
        String result_spl[] = string.split(" ");
        for (int i = 0; i < result_spl.length; i++){
            if (result_spl[i].contains("@") || result_spl[i].matches("[0-9+]+")){
                System.out.println("Split complete! Found[" +splitCounter+ "Matches.  Returned: " + result_spl[i]);
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
            System.out.println("Test jednostkowy: wypisz załadowaną listę. ");
            System.out.println("Załadowano plik do pamięci!" + i + "Lini załadowane!");
            br.close();
            return mailContent;
        } catch (IOException e) {
            throw new CannotLoadMailDataException("Could not load data from file " + path, e);
        }*/
        Messenger msg = new Messenger();
        msg.criticalErrorRaport("Function not done yet!");

    }

    public static void filterMaches(boolean mail, boolean phone, ArrayList<String> mailContent){
        /*Iterator<String> iterator = mailContent.iterator();
        String s = "@";
        while(iterator.hasNext()){
            if (mailContent.contains(s)){
                System.out.println("Mamy dopasowanie!");
            }
        }*/
        /*for (String f : mailContent){
            if (mailContent.get(s).contains("@") || mailContent.get(i).matches("[0-9+]+")){
                System.out.println("Mamy dopasowanie!");
            }
        }*/
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
