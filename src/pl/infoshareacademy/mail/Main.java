package pl.infoshareacademy.mail;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Messenger msg = new Messenger();
        System.out.println();
        // handle user commands
        boolean quit = false;
        int menuItem;
        do {
            Menu.PrintMenu();
            System.out.print("Choose menu item: ");
            while (!in.hasNextInt()) {
                msg.warningErrorReport("Please provide number!");
                Menu.PrintMenu();
                in.next();
            }
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("You've chosen item #1");
                    KeyWords keyWords = new KeyWords();
                    keyWords.KeyWordsIdentification();
                    break;
                case 2:
                    System.out.println("You've chosen item #2");
                    msg.criticalErrorRaport("Function no implemented yet!");
                    break;
                case 3:
                    System.out.println("You've chosen item #3");
                    msg.criticalErrorRaport("Function no implemented yet!");
                    break;
                case 4:
                    System.out.println("You've chosen item #4");

                    Finder mail = new Finder();
                    mail.runable();
                    ContactFinder searchmail = new ContactFinder();
                    searchmail.FindMail(mail);
                    searchmail.FindPhoneNo(mail);
                    searchmail.FindWebsite(mail);

                    break;
                case 5:
                    System.out.println("You've chosen item #5");
                    msg.criticalErrorRaport("Function no implemented yet!");
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println("Exiting main loop!");
    }
}
