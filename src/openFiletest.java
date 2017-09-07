import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class openFiletest {
    FileReader fileReader = new FileReader ("/home/michalrichert/IdeaProjects/jjdd2-gity-z-githuba/src/testlist.mbox");{

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String textLine = bufferedReader.readLine();

            do {
                textLine = bufferedReader.readLine();
                Pattern compiledPattern = Pattern.compile("From");
                Matcher line = compiledPattern.matcher(textLine);

                System.out.println(textLine);
                System.out.println(line.group());
                textLine = bufferedReader.readLine();
            } while (textLine != null);

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public openFiletest() throws FileNotFoundException {
    }
}
