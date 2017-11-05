package pl.infoshareacademy.mail.mailparser;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.MessageBuilder;
import org.apache.james.mime4j.dom.address.Mailbox;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;
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
    private static final Logger logger = LogManager.getLogger(MboxParser.class.getName());
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
        } catch (IllegalArgumentException e) {
            logger.warn("Incorrect structure of file");
        } catch (FileNotFoundException e) {
            logger.warn("File not found");
        } catch (IOException e) {
            logger.error("Stream error");
        }
    }

    private void messageSummary(InputStream messageBytes) {

        MessageBuilder builder = new DefaultMessageBuilder();
        Message message = null;
        try {
            message = builder.parseMessage(messageBytes);
        } catch (IOException eio) {
            logger.fatal("IO exception can't parse message or header", eio);
        } catch (MimeException emime) {
            logger.fatal("Mime exception can't parse message or header, probably incorrect structure of file", emime);
        } catch (NullPointerException enp) {
            logger.warn("NullPointer exception can't parse file", enp);
        }

        Email email = new Email();
        if (message != null) {
            Optional<String> reply = Optional.ofNullable(message.getBody().toString());
            Optional<String> from = Optional.ofNullable(message.getFrom().toString());
            Optional<String> to = Optional.ofNullable(message.getTo().toString());
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
        } else {
            email.setMessage("Could not parse file");
            logger.error("Encountered problem with parsing message");
        }
    }

    private void addMessage(MailBox mailBox) throws FileNotFoundException, EmptyFileException {
        MboxParserMessage message = new MboxParserMessage(path, supportmailbox);
        message.run(mailBox);
    }
}
