package pl.infoshareacademy.mail.mailparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.Main;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Optional;
import java.util.Properties;

public class EmlParser {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void parseEml(String emlFile, MailBox mailBox) {
        try {
            Properties props = System.getProperties();
            Session mailSession = Session.getDefaultInstance(props, null);
            InputStream source = null;
            source = new FileInputStream(new File(emlFile));
            MimeMessage message = new MimeMessage(mailSession, source);
            Email email = new Email();
            email.setMessage(message.getContent().toString());
            email.setSubject(message.getSubject());
            email.setDate(message.getSentDate());

            Optional<Address> senderObject = Optional.ofNullable(message.getSender());
            String sender = senderObject.map(v -> v.toString()).orElse("Not found");
            email.setSender(sender);
            email.setFrom(message.getFrom()[0].toString());
            mailBox.getMailbox().add(email);

        } catch (FileNotFoundException e) {
            logger.warn("File not found");
        } catch (MessagingException e) {
            logger.warn("Incorrect structure of file");
        } catch (IOException e) {
            logger.error("Stream error");
        } catch (Exception e) {
            logger.fatal("Can't parse file");
        }
    }
}