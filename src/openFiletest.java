import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class openFiletest {
    String wholembox ="";
    String MailAdress_complete_Tag="([a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.][a-zA-Z])";
    String MailAdress_without_country="([a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z][\\w\\.-]*[a-zA-Z0-9])";
    String MailAdress_Tag="("+MailAdress_complete_Tag+"|"+MailAdress_without_country+"|MAILER-DAEMON)";
    String Time_Tag="[a-zA-Z0-9: ]{24}";
    String Start_Tag="From\\s"+MailAdress_Tag+"*\\s\\s"+Time_Tag;
    String End_Tag="((?="+Start_Tag+")|$)";


    public String fileread() throws FileNotFoundException {
        FileReader fileReader = new FileReader("/home/michalrichert/IdeaProjects/jjdd2-gity-z-githuba/src/testlist.mbox");
        {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String textLine = bufferedReader.readLine();
                do {
                    wholembox += textLine;
                    textLine = bufferedReader.readLine();
                    continue;

                } while (textLine != null);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(wholembox);
        }
        return wholembox;
    }

    public openFiletest() throws FileNotFoundException {
    }
    public void message()
    {
        Pattern regex = Pattern.compile(From(.*?));
        Matcher line = regex.matcher(wholembox);
        System.out.println(line.group());
    }
}
