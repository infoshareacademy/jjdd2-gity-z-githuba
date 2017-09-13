import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class ContactFinder {

                public static void FindMail() {
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
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

    public static void splitter(java.lang.String string){
        java.lang.String splitterResult[] = string.split("\\s");
        for (int i = 0; i < splitterResult.length; i++){
            if (splitterResult[i].matches("\\w+@\\w+\\.\\w+")
                    || splitterResult[i].matches("([\\d\\ +\\-)(])+?")
                    && splitterResult[i].length() >= 7) {
                System.out.println("Email contact found: " + splitterResult[i]);
            }
        }
    }
    //TODO Wyrzuca listę stringów z emailami lub telefonami do wyboru

    public class FindPhone {
        File mboxfile;
        Scanner sc;
        ArrayList<String> maillist = new ArrayList();
        public FindPhone(String FilePath) {
            mboxfile = new File(FilePath);
        }
        public void message() throws FileNotFoundException {
            sc = new Scanner(mboxfile);
            sc.useDelimiter("\\n{3}");
            while (sc.hasNext()) {
                maillist.add(sc.next());
            
            }
        }
    }
    public static void notSplitted(String string){
        String lineByLineText[] = string.split("$");
        for (int i = 0; i < lineByLineText.length; i++){
            if (lineByLineText[i].matches("[\\d+\\s \\-)(]+?")){
                System.out.println("Email contact found: " + lineByLineText[i]);
            }
        }
    }
}

