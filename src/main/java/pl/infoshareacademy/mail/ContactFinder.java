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
        Set<String> sortedMail = new HashSet<>();
        KeyWords keywords = new KeyWords();

        for (int k = 0; k < list.size(); k++) {
            String splitterResult[] = list.get(k).getMessage().split("\\s");
            System.out.println(splitterResult);
            for (int i = 0; i < splitterResult.length; i++){
                for (int j = 0; j < keywords.getKeywordsSelected().size(); j++) {
                    if (splitterResult[i].matches(keywords.getKeywordsSelected().get(j))) {
                    sortedMail.addAll(list.get(k));
                    }
                }
            }
        }
        for (String sortedMailDisplay : sortedMail) {
            System.out.println("Emails containing keyword: " + sortedMailDisplay);
        }
    }

}
