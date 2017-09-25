package pl.infoshareacademy.mail;
import pl.infoshareacademy.mail.mailparser.MailBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactFinder {

    public void FindMail(Finder finder) {

        List<Email> list = finder.getEmailList();
        Set<String> eFound = new HashSet<String>();

        for (Email e : list) {
            String splitterResult[] = e.getMessage().split("\\s");
            for (int i = 0; i < splitterResult.length; i++) {
                if (splitterResult[i].matches("\\w+@\\w+\\.\\w+")) {
                    eFound.add(splitterResult[i]);
                }
            }
        }
        for (String emails : eFound) {
            System.out.println("Email contacts found: " + emails);
        }
    }

    public void FindPhoneNo(Finder finder) {

        List<Email> list = finder.getEmailList();
        Set<String> pFound = new HashSet<String>();
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
    public void FindWebsite(Finder finder) {

        List<Email> list = finder.getEmailList();
        Set<String> wFound = new HashSet<String>();
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
    public void FindAll (){
       
    }
}
