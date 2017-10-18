package pl.infoshareacademy.mail;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Singleton
public class StatisticBean {
    Map<String,Integer> mapKeyWords =new HashMap<>();
}
