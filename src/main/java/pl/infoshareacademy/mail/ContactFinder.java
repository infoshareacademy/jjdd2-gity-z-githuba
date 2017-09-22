package pl.infoshareacademy.mail;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactFinder {
    private static final Logger logger = LogManager.getLogger(ContactFinder.class.getName());



    public void FindMail(Finder finder) {
        logger.info("Trying to find email from findMail method");
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
            logger.info("Found E-Mail!");
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
            logger.info("Found Phone Number!");
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
            logger.info("Found Website!");
        }
    }
}
