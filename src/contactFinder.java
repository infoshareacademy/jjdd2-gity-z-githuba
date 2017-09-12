import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class contactFinder {

                public java.lang.String PrintMenuAnalyze(java.lang.String string){
                System.out.println("Please enter ABSOLUTE path to e-mail to analyze: ");
                System.out.println("Example: /home/user/mail.txt");
                Scanner scanner = new Scanner(System.in);
                java.lang.String path = scanner.nextLine();

                try {
                    FileReader fr = new FileReader(path);
                    BufferedReader br = new BufferedReader(fr);
                    java.lang.String buffor = br.readLine();
                    while (buffor != null){
                        if (buffor.contains("@") || (buffor.matches("[0-9+]+")) && buffor.length() == 9) {
                            System.out.println(_split(buffor));
                        }
                        buffor = br.readLine();
                    } br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    public static void _split(java.lang.String string){
        int n = 0;
        java.lang.String result_spl[] = string.split(" ");
        for (int i = 0; i < result_spl.length; i++){
            if (result_spl[i].contains("@") || result_spl[i].matches("[0-9+]+")){
                System.out.println("Split complete! Returned: " + result_spl[i]);
                n++;

            }

        }

    }












}

