package pl.infoshareacademy.mail;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class StatisticBean {
    private Map<String, Integer> mapKeyWords = new HashMap<>();


    public void countWords(List<String> listofWords) {
        for (String list : listofWords) {
            if (mapKeyWords.containsKey(list.toLowerCase())) {
                mapKeyWords.put(list.toLowerCase(), mapKeyWords.get(list) + 1);
            } else {
                mapKeyWords.put(list.toLowerCase(), 1);
            }
        }
    }

    public Map<String, Integer> getMapKeyWords() {
        return mapKeyWords;
    }
}