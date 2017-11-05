package pl.infoshareacademy.mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailUtilGmail {

    public MailUtilGmail() {
    }


    public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML, File attachment)
            throws javax.mail.MessagingException, java.io.UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtps.host", "smtp.gmail.com");
            props.put("mail.smtps.port", 465);
            props.put("mail.smtps.auth", "true");
            props.put("mail.smtps.quitwait", "false");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            Properties sProps = System.getProperties();
            sProps.put("mail.mime.base64.ignoreerrors", "true");

            Message message = new javax.mail.internet.MimeMessage(session);
            message.setSubject(subject);
            if (bodyIsHTML) {
                message.setContent(body, "text/html");
            } else {
                message.setText(body);
            }

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(body);

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = attachment.getName();

            messageBodyPart2.attachFile(attachment);

            Multipart multipart = new javax.mail.internet.MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            message.setContent(multipart);

            Address fromAddress = new InternetAddress(from, "Chart App");
            Address toAddress = new InternetAddress(to);
            message.setFrom(fromAddress);
            message.setRecipient(javax.mail.Message.RecipientType.TO, toAddress);

            Transport transport = session.getTransport();
            transport.connect("gityzgithuba@gmail.com", "hahaadmin");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (IOException ex) {
            Logger.getLogger(MailUtilGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}