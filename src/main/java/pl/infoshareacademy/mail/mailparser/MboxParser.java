package pl.infoshareacademy.mail.mailparser;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.MessageBuilder;
import org.apache.james.mime4j.dom.address.Mailbox;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.EmptyFileException;

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

    private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();
    String path;
    File mbox;
    ArrayList<Email> supportmailbox = new ArrayList<>();

    public MboxParser(String path) {
        this.path=path;
        mbox= new File(path);

    }
        public  void run() throws IOException, MimeException {
           for (CharBufferWrapper message : MboxIterator.fromFile(mbox).charset(ENCODER.charset()).build()) {
              messageSummary(message.asInputStream(ENCODER.charset()));
          }
            try {
                addMessage();
            } catch (EmptyFileException e) {
                e.printStackTrace();
            }
        }


        private void messageSummary(InputStream messageBytes) throws IOException, MimeException {

                MessageBuilder builder = new DefaultMessageBuilder();
                Message message = builder.parseMessage(messageBytes);

            Email email = new Email();
            Optional<String> from =Optional.ofNullable((message.getFrom().toString()));
            Optional<String> to =Optional.ofNullable((message.getTo().toString()));
            Optional<Mailbox> senderObject =Optional.ofNullable(message.getSender());
            String sender = senderObject.map(v -> v.toString()).orElse("Not found");


            Optional<Date> date =Optional.ofNullable(message.getDate());
            Optional<String> subject =Optional.ofNullable(message.getSubject());


                    email.setFrom(from.orElse("Not found"));
                    email.setTo(to.orElse("Not found"));
                    email.setSender(sender);
                    email.setDate(date.orElse(new Date()));
                    email.setSubject(subject.orElse("Not found"));
                    supportmailbox.add(email);


        }
        private void addMessage() throws FileNotFoundException, EmptyFileException {
        MboxParserMessage message = new MboxParserMessage(path,supportmailbox);
        message.run();
        }
    }
