package pl.infoshareacademy.mail;
import pl.infoshareacademy.mail.mailparser.MailBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactFinder {


    public void FindMail(MailBox mailbox) {

        ArrayList<Email> list = mailbox.getMailbox();
        Set<String> eFound = new HashSet<>();

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++) {
                if (splitterResult[i].matches("\\w+@\\w+\\.\\w+")) {
                    eFound.add(splitterResult[i]);
                }
            }
        }
        for (String emailResult : eFound) {
            System.out.println("Email contacts found: " + emailResult);
        }
    }

    public void FindPhoneNo(MailBox mailbox) {

        ArrayList<Email> list = mailbox.getMailbox();
        Set<String> pFound = new HashSet<>();

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++) {
                if (splitterResult[i].matches("([\\d\\s+\\-)(])+?")
                        && splitterResult[i].length() >= 7) {
                    pFound.add(splitterResult[i]);
                }
            }
        }
        for (String phones : pFound) {
            System.out.println("Phone numbers found: " + phones);
        }
    }
    public void FindWebsite(MailBox mailbox) {

        ArrayList<Email> list = mailbox.getMailbox();
        Set<String> wFound = new HashSet<>();

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++) {
                if (splitterResult[i].matches("(http).+")
                        || splitterResult[i].matches("(www).+")) {
                    wFound.add(splitterResult[i]);
                }
            }
        }
        for (String websites : wFound) {
            System.out.println("Websites or Links found: " + websites);
        }
    }

    public void FindQA (MailBox mailbox){
        ArrayList<Email> list = mailbox.getMailbox();
        Set<Set<String>> sortedMail = new HashSet<>();
        KeyWords keywords = new KeyWords();
        Set matchingMail = new HashSet();
        System.out.println("before Q&A\n"+keywords.getKeywordsSelected());
        System.out.println("Q&A\n"+keywords.KeyWordsIdentification());
        System.out.println("afterQ&A\n"+keywords.getKeywordsSelected());

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            System.out.println("\ngetMessage content\n"+e.getMessage());
            System.out.println("\ngetMessage split content\n"+e.getMessage().split("\\s"));

            for (int i = 0; i < splitterResult.length; i++){
                    if (splitterResult[i].matches("urgent")) {
                        System.out.println("\nspliter result"+i+"\n"+splitterResult[i]);
                        matchingMail.add(e.getFrom());
                        matchingMail.add(e.getSender());
                        matchingMail.add(e.getDate());
                        matchingMail.add(e.getSubject());
                        matchingMail.add(e.getMessage());
                        sortedMail.add(matchingMail);
                    }
            }
        }
        System.out.println("\nmatchingMail content\n"+matchingMail);
        System.out.println("\nsortedMail content\n"+sortedMail+"\n");
        //for (List sortedMailDisplay : sortedMail) {
        //    System.out.println("Emails containing keyword: " + sortedMailDisplay);
        //}
    }

}
