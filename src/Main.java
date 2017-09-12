import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.logging.FileHandler;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        openFiletest openFiletest = new openFiletest("/home/michalrichert/Downloads/testlist.mbox");
        openFiletest.message();
        System.out.println(openFiletest.maillist.get(3));

    }
}