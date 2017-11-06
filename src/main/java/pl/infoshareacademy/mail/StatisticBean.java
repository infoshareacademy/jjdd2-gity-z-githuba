package pl.infoshareacademy.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Singleton;
import java.util.*;

@Singleton
public class StatisticBean {
    private Map<String, Integer> mapKeyWords = new HashMap<>();
    private Map<String, Integer> mapWebsite = new HashMap<>();
    private Map<String, Integer> mapPhone = new HashMap<>();
    private Map<String, Integer> mapEmails = new HashMap<>();
    private List<String> adminPannelAccessUsers = new ArrayList<>();
    private String listofgmailwords;
    private final Logger logger = LogManager.getLogger(getClass());


    public void countWords(List<String> listofWords, Map<String, Integer> mapToCount) {
        for (String list : listofWords) {
            if (mapToCount.containsKey(list.toLowerCase())) {
                try {
                    mapToCount.put(list.toLowerCase(), mapToCount.get(list) + 1);
                } catch (NullPointerException ex) {
                    logger.warn("Empty map {} {}", list, listofWords);
                }
            } else {
                mapToCount.put(list.toLowerCase(), 1);
            }
        }
    }

    public void countWords(Set<String> listofWords, Map<String, Integer> mapToCount) {
        for (String list : listofWords) {
            if (mapToCount.containsKey(list.toLowerCase())) {
                try {
                    mapToCount.put(list.toLowerCase(), mapToCount.get(list) + 1);
                } catch (NullPointerException ex) {
                    logger.warn("Empty map {} {}", list, listofWords);
                }
            } else {
                mapToCount.put(list.toLowerCase(), 1);
            }
        }
    }

    public List<String> getAdminPannelAccessUsers() {
        return adminPannelAccessUsers;
    }

    public void setAdminPannelAccessUsers(List<String> adminPannelAccessUsers) {
        this.adminPannelAccessUsers = adminPannelAccessUsers;
    }
    public void addAdmintoList(){
        adminPannelAccessUsers.add("google-oauth2|113092233730131915485");
        adminPannelAccessUsers.add("google-oauth2|101939476130838913705");
    }
    public boolean isAdmin(String user){
        return adminPannelAccessUsers.contains(user);
    }

    public Map<String, Integer> getMapKeyWords() {
        return mapKeyWords;
    }

    public Map<String, Integer> getMapWebsite() {
        return mapWebsite;
    }

    public Map<String, Integer> getMapPhone() {
        return mapPhone;
    }

    public Map<String, Integer> getMapEmails() {
        return mapEmails;
    }

    public String getListofgmailwords() {
        return listofgmailwords;
    }

    public void setListofgmailwords(String listofgmailwords) {
        this.listofgmailwords = listofgmailwords;
    }
}