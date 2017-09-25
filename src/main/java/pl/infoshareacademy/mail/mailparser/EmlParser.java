//package pl.infoshareacademy.mail.mailparser;
//
//import java.io.File;
//
//public class EmlParser {
//
//    public static void main(String args[]) throws Exception {
//        display(new File("/home/mr/1.eml"));
//    }
//
//
//    public static void display(File emlFile) throws Exception{
//
//        Session mailSession = Session.getDefaultInstance(props, null);
//        InputStream source = new FileInputStream(emlFile);
//        MimeMessage message = new MimeMessage(mailSession, source);
//
//
//        System.out.println("Subject : " + message.getSubject());
//        System.out.println("From : " + message.getFrom()[0]);
//        System.out.println("--------------");
//        System.out.println("Body : " +  message.getContent());
//        message.getFrom();
//        message.getSubject();
//        message.getSentDate();
//        message.getContent();
//        message.getSender();
//    }
//}
