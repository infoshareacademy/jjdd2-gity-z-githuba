package pl.infoshareacademy.mail;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Aplication startup.");
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
                logger.warn("Input missmach! Expected INT got other value!");
                Menu.PrintMenu();
                in.next();
            }
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    logger.info("Im in Menu {} right now!", menuItem);
                    KeyWords keyWords = new KeyWords();
                    keyWords.KeyWordsIdentification();
                    break;
                case 2:
                    logger.info("Im in Menu {} right now!", menuItem);
                    Menu.PrintMenuAnalyze();
                    System.out.println("You've chosen item #2");
                    MailBox mailBox=new MailBox();
                    MboxParser parser = new MboxParser("/home/artur/test.mbox");
                    parser.run(mailBox);
                    ContactFinder searcher = new ContactFinder();
                    searcher.findQA(mailBox,"urgent");
                    break;
                case 3:
                    logger.info("Im in Menu {} right now!", menuItem);
                    msg.criticalErrorRaport("Function no implemented yet!");
                    break;
                case 4:
                    logger.info("Im in Menu {} right now!", menuItem);
                    System.out.println("Please enter ABSOLUTE path to e-mail to analyze: ");
                    System.out.println("Example: /home/user/mail.mbox");
                    String filename= in.next();
                    filename =filename.toLowerCase();
                    break;
                case 5:
                    logger.info("Im in Menu {} right now!", menuItem);
                    msg.criticalErrorRaport("Function no implemented yet!");
                    break;
                case 0:
                    quit = true;
                    logger.info("Closing aplication!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println("Exiting main loop!");
    }
}
