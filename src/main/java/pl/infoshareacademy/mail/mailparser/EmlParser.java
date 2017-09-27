package pl.infoshareacademy.mail.mailparser;

import org.apache.james.mime4j.dom.address.Mailbox;
import pl.infoshareacademy.mail.Email;

import javax.mail.Address;
import javax.mail.Session;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.io.*;
import javax.mail.internet.*;

public class EmlParser {

    public static void parseEml(File emlFile,MailBox mailBox) throws Exception {

        Properties props = System.getProperties();
        //  props.put("mail.host", "smtp.dummydomain.com");
        // props.put("mail.transport.protocol", "smtp");
        Session mailSession = Session.getDefaultInstance(props, null);
        InputStream source = new FileInputStream(emlFile);
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
    }
}