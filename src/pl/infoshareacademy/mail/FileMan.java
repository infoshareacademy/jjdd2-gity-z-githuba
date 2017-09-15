package pl.infoshareacademy.mail;

import java.io.*;

public class FileMan {

    public static void writeFile(String text) {
        try {
            PrintWriter writer = new PrintWriter("/home/sowatheking/test.txt");
            writer.println(text);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
    }

    public static void OpenFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/home/sowatheking/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (fileReader != null) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String textLine = bufferedReader.readLine();
                do {
                    System.out.println(textLine);
                    textLine = bufferedReader.readLine();
                } while (textLine != null);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File not found!");
            }
        }

    }
}

