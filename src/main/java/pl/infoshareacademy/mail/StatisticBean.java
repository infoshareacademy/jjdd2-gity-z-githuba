package pl.infoshareacademy.mail;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Singleton
public class StatisticBean {
    private Map<String, Integer> mapKeyWords = new HashMap<>();
    private Map<String, Integer> mapWebsite = new HashMap<>();
    private Map<String, Integer> mapPhone = new HashMap<>();
    private Map<String, Integer> mapEmails = new HashMap<>();


    public void countWords(List<String> listofWords, Map<String, Integer> mapToCount) {
        if (!listofWords.isEmpty()) {
            for (String list : listofWords) {
                if (mapToCount.containsKey(list.toLowerCase())) {
                    if (!listofWords.contains("Empty")){
                        try {
                            mapToCount.put(list.toLowerCase(), mapToCount.get(list) + 1);
                        } catch (NullPointerException ex) {

                        }
                    }
                } else {
                    mapToCount.put(list.toLowerCase(), 1);
                }
            }
        }
    }
    public void countWords(Set<String> listofWords, Map<String, Integer> mapToCount) {
        if (!listofWords.isEmpty()) {
            for (String list : listofWords) {
                if (mapToCount.containsKey(list.toLowerCase())) {
                    if (!listofWords.contains("Empty")){
                        try {
                            mapToCount.put(list.toLowerCase(), mapToCount.get(list) + 1);
                        } catch (NullPointerException ex) {

                        }
                    }
                } else {
                    mapToCount.put(list.toLowerCase(), 1);
                }
            }
        }
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
}