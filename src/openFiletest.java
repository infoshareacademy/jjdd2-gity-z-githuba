import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class openFiletest {
    File mboxfile;
    Scanner sc;
    ArrayList<SeperateWholeMail> maillist = new ArrayList();


    public openFiletest(String FilePath) {
        mboxfile = new File(FilePath);
    }

    public void message() throws FileNotFoundException {

        sc =new Scanner(mboxfile);
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            SeperateWholeMail mail = new SeperateWholeMail();
            mail.setMessage(sc.next());
            maillist.add(mail);
        }

//        while (sc.hasNext()) {
//            System.out.println(sc.next());
//        }

//        Pattern regex = Pattern.compile("From");
//        Matcher line) = regex.matcher(wholembox);
//        //System.out.println(line.group("From"));
//        boolean t = line.matches();
//        System.out.println(t);
//
//        Pattern p = Pattern.compile("From(.+)");
//        Matcher m = p.("a aaaab");
//        boolean b = m.matches();
//        System.out.println(b);
//        System.out.println(m.group());
//
//        System.out.println(line.groupCount());
    }

    public void splitMessage() {
        for (SeperateWholeMail mail : maillist) {
            sc = new Scanner(mail.getMessage());
            sc.useDelimiter("\\n{2}");
            int i=1;
            while (sc.hasNext()) {
                String message =sc.next();
                if (i == 2) {
                    mail.setMessagecontent(message);
                    System.out.println(message);
                }
                i++;
            }
        }
    }
    public void splitMessage1() {

        System.out.println(maillist.get(1).getMessagecontent());
            }
        }


