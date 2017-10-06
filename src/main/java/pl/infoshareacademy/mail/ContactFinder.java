package pl.infoshareacademy.mail;
import pl.infoshareacademy.mail.mailparser.MailBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public Set FindQA (MailBox mailbox, String searchkeywords){
        ArrayList<Email> list = mailbox.getMailbox();
        KeyWords keywords = new KeyWords();
        Set matchingMail = new HashSet();
        System.out.println("Summary of keywords selected for You:\n"+keywords.KeyWordsIdentification());

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++){
                    if (splitterResult[i].matches(searchkeywords)) {
                        matchingMail.add(e.toString());
                    }
            }
        }
        System.out.println("\nmatchingMail content\n"+matchingMail);
        return matchingMail;
    }

}
