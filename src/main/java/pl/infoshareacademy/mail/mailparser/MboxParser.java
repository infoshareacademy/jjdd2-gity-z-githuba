package pl.infoshareacademy.mail.mailparser;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.MessageBuilder;
import org.apache.james.mime4j.dom.address.Mailbox;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import pl.infoshareacademy.mail.Email;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class MboxParser {

    public static ArrayList<Email> Skrzynka = new ArrayList<>();
        private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();

        // simple example of how to split an mbox into individual files
        public static void main(String[] args) throws Exception {
            if (args.length != 1) {
                System.out.println("Please supply a path to an mbox file to parse");
            }

            final File mbox = new File("/home/artur/test.mbox");
            MailBox mailbox=new MailBox();
            for (CharBufferWrapper message : MboxIterator.fromFile(mbox).charset(ENCODER.charset()).build()) {
                messageSummary(message.asInputStream(ENCODER.charset()),mailbox);
            }
        }

        private static void messageSummary(InputStream messageBytes,MailBox mailbox) throws IOException, MimeException {

                MessageBuilder builder = new DefaultMessageBuilder();
                Message message = builder.parseMessage(messageBytes);


            Email email = new Email();
            Optional<String> from =Optional.ofNullable((message.getFrom().toString()));
            Optional<String> to =Optional.ofNullable((message.getTo().toString()));
            Optional<Mailbox> senderObject =Optional.ofNullable(message.getSender());
            String sender = senderObject.map(v -> v.toString()).orElse("Not found");
            Optional<Date> date =Optional.ofNullable(message.getDate());
            Optional<String> contentMessage =Optional.ofNullable(message.getSubject());
            Optional<String> subject =Optional.ofNullable(message.getSubject());


                    email.setFrom(from.orElse("Not found"));
                    email.setTo(to.orElse("Not found"));
                    email.setSender(sender);
                    email.setDate(date.orElse(new Date()));
                    email.setMessage(contentMessage.orElse("Not found"));
                    email.setSubject(subject.orElse("Not found"));

            ArrayList<Email> mailboxsupport = mailbox.getMailbox();
            mailboxsupport.add(email);

        }
    }
