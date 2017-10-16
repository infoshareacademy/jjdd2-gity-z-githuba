package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;

import javax.ejb.Singleton;
import java.util.ArrayList;
@Singleton
public class MailBox {
    ArrayList<Email> Mailbox = new ArrayList<>();

    public ArrayList<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(ArrayList<Email> mailbox) {
        Mailbox = mailbox;
    }
}
