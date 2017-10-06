package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;

import java.util.ArrayList;

public class MailBox {
    ArrayList<Email> Mailbox = new ArrayList<>();

    public ArrayList<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(ArrayList<Email> mailbox) {
        Mailbox = mailbox;
    }
}
