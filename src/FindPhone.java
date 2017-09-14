import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class FindPhone {
    // Testowo
    List<String> mailbox = new ArrayList<>();

    public void message() {
        mailbox.add("694 981 944");

        for (String e : mailbox) {
            System.out.println(e.matches(("[\\d+\\s\\-)(]+?")));
        }
    }

}
