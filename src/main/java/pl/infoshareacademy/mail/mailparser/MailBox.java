package pl.infoshareacademy.mail.mailparser;

import pl.infoshareacademy.mail.Email;

import javax.ejb.Singleton;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> e61dbbae79ead5a8c5c567331c7c8e565c84ff02
@Singleton
public class MailBox {
    List<Email> Mailbox = new ArrayList<>();

    public List<Email> getMailbox() {
        return Mailbox;
    }

    public void setMailbox(List<Email> mailbox) {
        Mailbox = mailbox;
    }
}
