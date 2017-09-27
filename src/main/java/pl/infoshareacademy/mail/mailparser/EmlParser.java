package pl.infoshareacademy.mail.mailparser;

import org.apache.james.mime4j.dom.address.Mailbox;
import pl.infoshareacademy.mail.Email;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.io.*;
import javax.mail.internet.*;

public class EmlParser {

    public static void parseEml(File emlFile,MailBox mailBox) {
        try {
            Properties props = System.getProperties();
            Session mailSession = Session.getDefaultInstance(props, null);
            InputStream source = null;
            source = new FileInputStream(emlFile);
            MimeMessage message = new MimeMessage(mailSession, source);
            Email email = new Email();
            email.setMessage(message.getContent().toString());
            email.setSubject(message.getSubject());
            email.setDate(message.getSentDate());

            Optional<Address> senderObject =Optional.ofNullable(message.getSender());
            String sender = senderObject.map(v -> v.toString()).orElse("Not found");
            email.setSender(sender);
            email.setFrom(message.getFrom()[0].toString());
            mailBox.getMailbox().add(email);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}