import java.io.*;

public class File {
    public void writeFile() {
        try {
            PrintWriter writer = new PrintWriter("/home/sowatheking/test.txt");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
