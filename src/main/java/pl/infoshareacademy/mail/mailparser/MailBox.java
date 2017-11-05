package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@SessionScoped
public class MailBox implements Serializable{
    List<Email> Mailbox = new ArrayList<>();

    public List<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(List<Email> mailbox) {
        Mailbox = mailbox;
    }
}