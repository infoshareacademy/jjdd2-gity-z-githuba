package pl.infoshareacademy.mail.mailparser;

import javax.mail.Session;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.io.*;
import javax.mail.internet.*;

public class EmlParser {

    public static void main(String args[]) {
        try {
            display(new File("/home/michalrichert/1.eml"));
        } catch (NoSuchFieldException e) {
            System.out.println("Log.Info");
        } catch (Exception e) {
            System.out.println("Log.Warning");
        }
    }


    public static void display(File emlFile) throws Exception {

        Properties props = System.getProperties();
        //  props.put("mail.host", "smtp.dummydomain.com");
        // props.put("mail.transport.protocol", "smtp");

        Session mailSession = Session.getDefaultInstance(props, null);
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);


        System.out.println("Subject : " + message.getSubject());
        System.out.println("From : " + message.getFrom()[0]);
        System.out.println("--------------");
        System.out.println("Body : " + message.getContent());
    }
}