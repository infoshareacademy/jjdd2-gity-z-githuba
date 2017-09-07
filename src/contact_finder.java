import com.sun.org.apache.xpath.internal.operations.String;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class contact_finder {

    public static void main(String[] args){

        Pattern contactType1 = Pattern.compile("@");
        Matcher inputString = contactType1.matcher("aaa bbb@bbb.bb ccc");

        System.out.println(inputString.toString());











    }
}
