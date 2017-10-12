package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    List<Email> Mailbox = new ArrayList<>();

    public List<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(List<Email> mailbox) {
        Mailbox = mailbox;
    }
}
