package pl.infoshareacademy.mail.mailparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;
import pl.infoshareacademy.mail.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MboxParserMessage {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    String path;
    ArrayList<Email> arrayWithObject;
    ArrayList<String> arrayCointainsSeprateWholeMessage = new ArrayList<>();
    ArrayList<String> arrayContainsOnlyMessage = new ArrayList<>();

    public MboxParserMessage(String path, ArrayList<Email> arrayWithObject) {
        this.path = path;
        this.arrayWithObject = arrayWithObject;
    }

    public void run(MailBox mailBox) {
        splitMessagetoWholeMessage();
        splittMesegaContainsOnlyMessege();
        addMessagetoEmailClass();
        addEmailObjecttoMailBoxclass(mailBox);

    }

    public void splitMessagetoWholeMessage() {

        File file = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            arrayCointainsSeprateWholeMessage.add(sc.next());

        }
    }

    public void splittMesegaContainsOnlyMessege() {
        for (String e : arrayCointainsSeprateWholeMessage) {
            Scanner sc = new Scanner(e);
            sc.useDelimiter("\\n{2}");
            int i = 1;
            String wholecontent = "";
            while (sc.hasNext()) {
                String message = sc.next();
                if (i >= 2) {
                    wholecontent = wholecontent + System.lineSeparator() + message;
                }
                i++;
            }
            arrayContainsOnlyMessage.add(wholecontent);
        }
    }

    public void addMessagetoEmailClass() {

        if (arrayContainsOnlyMessage.isEmpty()) {
            try {
                throw new EmptyFileException("Empty file");
            } catch (EmptyFileException e) {
                logger.warn("Empty file");
            }
        }
        for (int i = 0; i < arrayWithObject.size(); i++) {
            arrayWithObject.get(i).setMessage(arrayContainsOnlyMessage.get(i));
        }
    }

    public void addEmailObjecttoMailBoxclass(MailBox mailBox) {
        ArrayList<Email> emptyarray = mailBox.getMailbox();
        for (int i = 0; i < arrayWithObject.size(); i++) {
            emptyarray.add(arrayWithObject.get(i));
        }

    }

}
