package pl.infoshareacademy.mail;

import java.io.*;
import java.util.*;


public class ContactFinder {

    public static void FindMail(Finder finder) {

        List<Email> list = finder.getEmailList();
        Set<String> eFound = new HashSet<String>();

        for (Email e : list) {
            e.getMessage();
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
            e.getMessage();
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
            e.getMessage();
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
   /* public static void FindMail(Finder finder) {

        String messageText;
        List<Email> list = finder.getEmailList();
        for (Email e : list) {
            messageText = e.getDescription();
            BufferedReader br = new BufferedReader(new StringReader(messageText));
            try {
                String messages = br.readLine();
                while (messages != null) {
                    splitter(messages);
                    messages = br.readLine();
                    System.out.println(messages);
                }
                br.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
            System.out.println(messageText);
        }

    }*/

   /* public static void splitter(java.lang.String string){
        java.lang.String splitterResult[] = string.split("\\s");
        for (int i = 0; i < splitterResult.length; i++){
            if (splitterResult[i].matches("\\w+@\\w+\\.\\w+")
                    || splitterResult[i].matches("([\\d\\s+\\-)(])+?")
                    && splitterResult[i].length() >= 7) {
                System.out.println("Email contact found: " + splitterResult[i]);
            }
        }
    }
    //TODO Wyrzuca listę stringów z emailami lub telefonami do wyboru

    public static class findPhone {
        File mboxfile;
        Scanner sc;
        ArrayList<String> maillist = new ArrayList();
        public findPhone(String FilePath) {
            mboxfile = new File(FilePath);
        }
        public void message() throws FileNotFoundException {
            sc = new Scanner(mboxfile);
            sc.useDelimiter("\\n{3}");
            while (sc.hasNext()) {
                maillist.add(sc.next());
                for (int i = 0; i < maillist.size(); i++) {
                    if (maillist.toString().matches("[\\d+\\s\\-)(]+?")){
                        System.out.println("Phone found: " + maillist);
                    }
                }
            }
        }
    }*/
    //public static void notSplitted(String string){
       // String lineByLineText[] = string.split("$");
        //for (int i = 0; i < lineByLineText.length; i++){
          //  if (lineByLineText[i].matches("[\\d+\\s\\-)(]+?")){
             //   System.out.println("Email contact found: " + lineByLineText[i]);

       // }
  //  }
//}

