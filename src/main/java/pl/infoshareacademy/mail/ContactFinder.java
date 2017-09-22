package pl.infoshareacademy.mail;
import com.sun.deploy.util.StringUtils;
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
        String str = StringUtils.join(eFound, ", ");
        System.out.println("Email contacts found: " + str);
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
            System.out.println("Websites or links found: " + websites);
        }
    }
    public static void filterMatches(boolean mail, boolean phone, ArrayList<String> mailContent){
        for (int i = 0; i < mailContent.size(); i++){
            if (mailContent.get(i).contains("\\w+@\\w+\\.\\w+")) {
                System.out.println("Email contacts found: " + mailContent.get(i));
                String[] splitResult = mailContent.get(i).split("\\s");
                for (int j = 0; j < splitResult.length; j++){
                }
            } else if (mailContent.get(i).matches("([\\d\\s+\\-)(])+?")
                    && mailContent.get(i).length() >= 7){
                System.out.println("Phone numbers found: " + mailContent.get(i));
            }
        }
    }
}
