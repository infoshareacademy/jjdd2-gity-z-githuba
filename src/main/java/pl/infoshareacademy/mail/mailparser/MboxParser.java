package pl.infoshareacademy.mail.mailparser;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.MessageBuilder;
import org.apache.james.mime4j.dom.address.Mailbox;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;
import pl.infoshareacademy.mail.Main;
import pl.infoshareacademy.mail.mailparser.mail.util.CharBufferWrapper;
import pl.infoshareacademy.mail.mailparser.mail.util.MboxIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class MboxParser {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();
    String path;
    File mbox;
    ArrayList<Email> supportmailbox = new ArrayList<>();

    public MboxParser(String path) {
        this.path = path;
        mbox = new File(path);

    }

    public void run(MailBox mailBox) {

        try {
            for (CharBufferWrapper message : MboxIterator.fromFile(mbox).charset(ENCODER.charset()).build()) {
                messageSummary(message.asInputStream(ENCODER.charset()));
                addMessage(mailBox);
            }
        } catch (EmptyFileException e) {
            logger.warn("Empty file");
        } catch (MimeException e) {
            logger.warn("Incorrect structure of file");
        } catch (IllegalArgumentException e) {
            logger.warn("Incorrect structure of file");
        } catch (FileNotFoundException e) {
            logger.warn("File not found");
        } catch (IOException e) {
            logger.error("Stream error");
        } catch (Exception e) {
            logger.fatal("Can't parse file",e);
        }
    }

//TODO eliminate throws
    private void messageSummary(InputStream messageBytes) throws IOException, MimeException {

        MessageBuilder builder = new DefaultMessageBuilder();
       // try {
            Message message = builder.parseMessage(messageBytes);
       // } catch (IOException eio) {
       //     logger.fatal("IO exception cant parse message or header",eio);
       // } catch (MimeException emime) {
       //     logger.fatal("Mime exception cant parse message or header",emime);
       // }

        Email email = new Email();
        Optional<String> reply =Optional.ofNullable(message.getBody().toString());
        Optional<String> from = Optional.ofNullable((message.getFrom().toString()));
        Optional<String> to = Optional.ofNullable((message.getTo().toString()));
        Optional<Mailbox> senderObject = Optional.ofNullable(message.getSender());
        String sender = senderObject.map(v -> v.toString()).orElse("Not found");
        Optional<Date> date = Optional.ofNullable(message.getDate());
        Optional<String> subject = Optional.ofNullable(message.getSubject());

        email.setFrom(from.orElse("Not found"));
        email.setTo(to.orElse("Not found"));
        email.setSender(sender);
        email.setDate(date.orElse(new Date()));
        email.setSubject(subject.orElse("Not found"));
        email.setReply(reply.orElse("Not found"));
        supportmailbox.add(email);

    }

    private void addMessage(MailBox mailBox) throws FileNotFoundException, EmptyFileException {
        MboxParserMessage message = new MboxParserMessage(path, supportmailbox);
        message.run(mailBox);
    }
}
