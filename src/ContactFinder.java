import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ContactFinder {

                public static void FindMailAndPhone() {
                    System.out.println("Please enter ABSOLUTE path to e-mail to analyze: ");
                    System.out.println("Example: /home/user/mail.txt");
                    Scanner scanner = new Scanner(System.in);
                    java.lang.String path = scanner.nextLine();

                    try {
                        FileReader fr = new FileReader(path);
                        BufferedReader br = new BufferedReader(fr);
                        java.lang.String buffor = br.readLine();
                        while (buffor != null) {
                            splitter(buffor);
                            buffor = br.readLine();
                        }
                        br.close();

                    FileReader fr2 = new FileReader(path);
                    BufferedReader br2 = new BufferedReader(fr2);
                    java.lang.String buffor2 = br2.readLine();
                    while (buffor2 != null) {
                        notSplitted(buffor2);
                        buffor2 = br2.readLine();
                    }
                    br2.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

    public static void splitter(java.lang.String string){
        java.lang.String splitterResult[] = string.split("\\s");
        for (int i = 0; i < splitterResult.length; i++){
            if (splitterResult[i].contains("@") || splitterResult[i].matches("[\\d+\\-)(]+?")){
                System.out.println("Email contact found: " + splitterResult[i]);
            }
        }
    }
    public static void notSplitted(String string){
        String lineByLineText[] = string.split("$");
        for (int i = 0; i < lineByLineText.length; i++){
            if (lineByLineText[i].matches("[\\d+\\-)(]+?")){
                System.out.println("Email contact found: " + lineByLineText[i]);
            }
        }
    }
}

