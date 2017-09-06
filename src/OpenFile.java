import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile {

    FileReader fileReader = new FileReader ("/home/michalrichert/IdeaProjects/jjdd2-gity-z-githuba/src/testlist.mbox");{

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

        String textLine = bufferedReader.readLine();
        do {
            System.out.println(textLine);

            textLine = bufferedReader.readLine();
        } while (textLine != null);

        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public OpenFile() throws FileNotFoundException {
    }
}
