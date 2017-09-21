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

public class MboxParser {

    public static ArrayList<Email> Skrzynka = new ArrayList<>();
        private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();

        // simple example of how to split an mbox into individual files
        public static void main(String[] args) throws Exception {
            if (args.length != 1) {
                System.out.println("Please supply a path to an mbox file to parse");
            }

            final File mbox = new File("/home/michalrichert/1.mbox");
            long start = System.currentTimeMillis();
            int count = 0;
            MailBox mailbox=new MailBox();
            for (CharBufferWrapper message : MboxIterator.fromFile(mbox).charset(ENCODER.charset()).build()) {
                messageSummary(message.asInputStream(ENCODER.charset()),mailbox);
                count++;
            }
            mailbox.getMailbox().forEach(email1 -> System.out.println(email1));
            System.out.println("Found " + count + " messages");
            long end = System.currentTimeMillis();
            System.out.println("Done in: " + (end - start) + " milis");
        }

        private static void messageSummary(InputStream messageBytes,MailBox mailbox) throws IOException, MimeException {
            MessageBuilder builder = new DefaultMessageBuilder();
            Message message = builder.parseMessage(messageBytes);
            Email email = new Email();
                    email.setMessage(message.getMessageId());
                    email.setFrom(message.getFrom().toString());
 //TO DO OPTIONAL NA NULLA                  // email.setSender(message.getSender().toString());
                    email.setDate(message.getDate());
                    email.setMessage(message.getSubject());
                  //  email.setSubject(message.getSender().toString());
            ArrayList<Email> mailboxsupport = mailbox.getMailbox();
            mailboxsupport.add(email);

        }
    }
