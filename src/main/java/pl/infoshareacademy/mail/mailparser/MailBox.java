package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;
@Stateful
public class MailBox {
    List<Email> Mailbox = new ArrayList<>();

    public List<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(List<Email> mailbox) {
        Mailbox = mailbox;
    }
}
