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
    List maillist = new ArrayList();


    public openFiletest(String FilePath) {
        mboxfile = new File(FilePath);
    }

    public void message() throws FileNotFoundException {

        sc =new Scanner(mboxfile);
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            maillist.add(sc.next());
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
        for (Scanner e : maillist) {

            sc =new Scanner(e.);
            sc.useDelimiter("\\n{3}");
            while (sc.hasNext()) {
                maillist.add(sc.next());
            }


        }


    }
}
