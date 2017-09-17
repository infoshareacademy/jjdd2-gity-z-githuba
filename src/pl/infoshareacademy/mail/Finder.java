package pl.infoshareacademy.mail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Finder {

    private List<Email> emailList ;
    private ArrayList<String> wholemail =new ArrayList<>();
    private ArrayList<String> splitMessage = new ArrayList<>();
    private String fileName;


    public Finder(String fileName) {
        emailList = new ArrayList<>();
        this.fileName=fileName;

    }
    public void runable() {
        try {
            findEmailAndDescription();
            message();
            splitMessage();
            addMessagetoObject();

        } catch (EmptyFileException ex) {
        } catch (IOException ex) {
            System.out.println("Wrong file path !");
        }
    }

    public void findEmailAndDescription() throws IOException {
        BufferedReader file = null;
        String from = null;
        String description = null;

        final Pattern compiledPattern = Pattern.compile("([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})");
        try {
            file = new BufferedReader(new FileReader(fileName));
            String singleLine = file.readLine();

            while (singleLine != null) {

                String[] tab = singleLine.split(" ");
                for (int i = 0; i < tab.length; i++) {
                    if (tab[i].equals("From")) {
                        Matcher matcher = compiledPattern.matcher(tab[i + 1]);
                        if (matcher.matches()) {
                            from = tab[i + 1];
                        }
                    } else if (tab[i].equals("Subject:")) {
                        description = tab[i + 1] + " ";
                        for (int j = i + 2; j < tab.length; j++) {
                            description += tab[j] + " ";
                        }
                    }

                    if (from != null && description != null) {
                        addEmailToArrayList(emailList, from, description);
                        from = null;
                        description = null;
                    }
                }
                singleLine = file.readLine();
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    public void message() throws FileNotFoundException {

        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            wholemail.add(sc.next());
        }
    }

    public void splitMessage() {
        for (String e : wholemail) {
            Scanner sc = new Scanner(e);
            sc.useDelimiter("\\n{2}");
            int i=1;
            String wholecontent = "";
            while (sc.hasNext()) {
                String message =sc.next();
                if (i >= 2) {
                    wholecontent =wholecontent+System.lineSeparator() +message;
                }
                i++;
            }
            splitMessage.add(wholecontent);
        }
    }

    public void addMessagetoObject() throws EmptyFileException {
        if (wholemail.isEmpty()) {
            throw new EmptyFileException("Empty file");
        }
        for (int i = 0; i <emailList.size() ; i++) {
            emailList.get(i).setMessage(splitMessage.get(i));
        }
    }



    public void addEmailToArrayList(final List<Email> list,final String from,final String description) {
        Email email = new Email();
        email.setFrom(from);
        email.setDescription(description);
        list.add(email);
    }

    public void displayAllEmails() {
        int number = 0;
        for (final Email iter : emailList) {
            number ++;
            System.out.println("_______________________________________________________________");
            System.out.println("Number: "+number);
            System.out.println("From: " + iter.getFrom());
            System.out.println("Subject: " + iter.getDescription());
            System.out.println("Content: " + iter.getMessage());
            System.out.println("_______________________________________________________________");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finder finder = (Finder) o;
        return emailList != null ? emailList.equals(finder.emailList) : finder.emailList == null;
    }

    @Override
    public int hashCode() {
        return emailList != null ? emailList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Finder{" +
                "emailList=" + emailList +
                '}';
    }

    public List<Email> getEmailList() {
        return emailList;
    }
    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

}
