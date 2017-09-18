package pl.infoshareacademy.mail;

import java.io.*;
import java.util.*;


public class ContactFinder {

    public static void FindMail(Finder finder) {

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

    public static void FindPhoneNo(Finder finder) {

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
    public static void FindWebsite(Finder finder) {

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
}
  