package pl.infoshareacademy.mail.mailparser;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.MessageBuilder;
import org.apache.james.mime4j.message.DefaultMessageBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class MboxParser {

    /**
     * Simple example of how to use Apache Mime4j Mbox Iterator. We split one mbox file file into
     * individual email messages.
     */

        private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();

        // simple example of how to split an mbox into individual files
        public static void main(String[] args) throws Exception {
            if (args.length != 1) {
                System.out.println("Please supply a path to an mbox file to parse");
            }

            final File mbox = new File("/home/mr/1.mbox");
            long start = System.currentTimeMillis();
            int count = 0;

            for (CharBufferWrapper message : MboxIterator.fromFile(mbox).charset(ENCODER.charset()).build()) {
                // saveMessageToFile(count, buf);

                System.out.println(messageSummary(message.asInputStream(ENCODER.charset())));
                count++;
            }
            System.out.println("Found " + count + " messages");
            long end = System.currentTimeMillis();
            System.out.println("Done in: " + (end - start) + " milis");
        }

        private static void saveMessageToFile(int count, CharBuffer buf) throws IOException {
            FileOutputStream fout = new FileOutputStream(new File("target/messages/msg-" + count));
            FileChannel fileChannel = fout.getChannel();
            ByteBuffer buf2 = ENCODER.encode(buf);
            fileChannel.write(buf2);
            fileChannel.close();
            fout.close();
        }

        /**
         * Parse a message and return a simple {@link String} representation of some important fields.
         *
         * @param messageBytes the message as {@link java.io.InputStream}
         * @return String
         * @throws IOException
         * @throws MimeException
         */
        private static String messageSummary(InputStream messageBytes) throws IOException, MimeException {
            MessageBuilder builder = new DefaultMessageBuilder();
            Message message = builder.parseMessage(messageBytes);
            return String.format("\nMessage %s \n" +
                            "Sent by:\t%s\n" +
                            "To:\t%s\n",
                    message.getSubject(),
                    message.getSender(),
                    message.getTo(),
                    message.getDate());

        }
    }
