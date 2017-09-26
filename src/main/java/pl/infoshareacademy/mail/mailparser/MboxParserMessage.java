package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;

import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MboxParserMessage {
    String path;
    ArrayList<Email> supportmail;
    ArrayList<String> supportmessage = new ArrayList<>();
    ArrayList<String> supportmessageextract = new ArrayList<>();

    public MboxParserMessage(String path, ArrayList<Email> supportmail) {
        this.path = path;
        this.supportmail = supportmail;
    }

    public void run(MailBox mailBox) throws FileNotFoundException, EmptyFileException {
        message();
        splitMessage();
        mboxParserMessage();
        addEmailObjecttoMailBoxclass(mailBox);

    }

    public void message() throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            supportmessage.add(sc.next());

        }
    }

    public void splitMessage() {
        for (String e : supportmessage) {
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
            supportmessageextract.add(wholecontent);
        }
    }

    public void mboxParserMessage() throws EmptyFileException {

        if (supportmessageextract.isEmpty()) {
            throw new EmptyFileException("Empty file");
        }
        for (int i = 0; i < supportmail.size(); i++) {
            supportmail.get(i).setMessage(supportmessageextract.get(i));
        }
    }

    public void addEmailObjecttoMailBoxclass(MailBox mailBox) {
        ArrayList<Email> emptyarray = mailBox.getMailbox();
        for (int i = 0; i <supportmail.size() ; i++) {
            emptyarray.add(supportmail.get(i));
        }

    }

}
