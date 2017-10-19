package pl.infoshareacademy.mail;

import pl.infoshareacademy.mail.mailparser.MailBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactFinder {

    public Set<String> findMail(MailBox mailbox) {

        List<Email> list = mailbox.getMailbox();
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
        return eFound;
    }

    public Set findPhoneNo(MailBox mailbox) {

        List<Email> list = mailbox.getMailbox();
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
        return pFound;
    }

    public Set findWebsite(MailBox mailbox) {

        List<Email> list = mailbox.getMailbox();
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
            return wFound;
    }

    public Set findQA(MailBox mailbox, String searchkeywords){

        List<Email> list = mailbox.getMailbox();
        Set matchingMail = new HashSet();

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++){
                if (splitterResult[i].matches(searchkeywords)) {
                    matchingMail.add(e);
                }
            }
        }
        System.out.println(matchingMail);
        return matchingMail;
    }
}
