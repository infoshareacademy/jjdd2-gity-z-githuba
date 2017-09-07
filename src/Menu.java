import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
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
        System.out.format("%-60s - UNAVALIBLE%n","1. What keywords should i use to find mine email?");
        System.out.format("%-60s - UNAVALIBLE%n","2. Analyze contact data from mine e-mail");
        System.out.format("%-60s - UNAVALIBLE%n","3. Show me mine top 10 customer's");
        System.out.format("%-60s - UNAVALIBLE%n","4. Filter mine contact's (Single .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","5. Filter mine contact's (Multiple .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","6. Show me abandoned customers");
        System.out.println();
        System.out.println("0. Quit");
    } // Function that prints menu on the screen

    public static void PrintMenuKeywords() {
        Scanner scanner = new Scanner(System.in);
        System.out.format("%-60s - UNAVALIBLE%n", "1. Is this urgent correspondance?? (Y/N):");
        String answer1 = scanner.nextLine().toLowerCase();
        System.out.format("%-60s - UNAVALIBLE%n", "2. Is it private correspondence? (Y/N):");
        String answer2 = scanner.nextLine().toLowerCase();
        System.out.format("%-60s - UNAVALIBLE%n", "3. Is it bussines related correspondance? (Y/N):");
        String answer3 = scanner.nextLine().toLowerCase();

        if (answer1 == "y") {
            // Odszukaj w pliku linie "[Urgent], wylistuj wszystko do pustej lini
        }

        if (answer2 == "y") {
            // Odszukaj w pliku linie "[Private], wylistuj wszystko do pustej lini
        }

        if (answer3 == "y") {
            // Odszukaj w pliku linie "[Business], wylistuj wszystko do pustej lini
        }

    }

    public static void PrintMenuAnalyze(){
        System.out.format("%-60s - UNAVALIBLE%n", "Please enter ABSOLUTE path to e-mail to analyze: ");
        System.out.println("Example: /home/user/mail.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        // Potrzeba kodu do otwarcia e-mail, spróbuje zrobić to na stałym pliku
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String buffor = br.readLine();
            while (buffor != null){
                if (buffor.contains("@")){
                    System.out.println(buffor);
                }
                buffor = br.readLine();
            } br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static
}
