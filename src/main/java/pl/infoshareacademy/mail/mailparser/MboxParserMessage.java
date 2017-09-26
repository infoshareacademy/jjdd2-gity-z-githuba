package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MboxParserMessage {
    String path;
    ArrayList <Email> supportmail;
    ArrayList <String> supportmessage= new ArrayList<>();
    ArrayList <String> supportmessageextract= new ArrayList<>();
    public MboxParserMessage(String path,ArrayList<Email> supportmail) {
        this.path=path;
        this.supportmail=supportmail;
    }
    public  void run() throws FileNotFoundException, EmptyFileException {
        message();
        splitMessage();
        addMessagetoObject();
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
            int i=1;
            String wholecontent = "";
            while (sc.hasNext()) {
                String message =sc.next();
                if (i >= 2) {
                    wholecontent =wholecontent+" "+message;
                }
                i++;
            }
            supportmessageextract.add(wholecontent);
        }
    }

    public void addMessagetoObject() throws EmptyFileException {
        if (supportmessageextract.isEmpty()) {
            throw new EmptyFileException("Empty file");
        }
        for (int i = 0; i <supportmail.size() ; i++) {
            supportmail.get(i).setMessage(supportmessageextract.get(i));
        }
        supportmail.forEach(e-> System.out.println(e.toString()));
    }
    public void addWholetoMailbox(MailBox mail) {
        mail.getMailbox()=supportmail.toArray();
    }

}
