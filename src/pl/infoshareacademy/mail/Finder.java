package pl.infoshareacademy.mail;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;


public class Finder {

    private List<Email> emailList ;
    private ArrayList<String> wholemail =new ArrayList<>();
    private ArrayList<String> splitMessage = new ArrayList<>();
    private String fileName;


    public Finder(String file ) {
        emailList = new ArrayList<>();
        this.file=fileName;

    }
    public void runable() {
        findEmailAndDescription();
        message();
        splitMessage();
        addMessagetoObject();
    }

    public void findEmailAndDescription() throws IOException {
        BufferedReader file = null;
        String from = null;
        String description = null;


        final Pattern compiledPattern = Pattern.compile("[A-za-z.]+@[A-za-z]+\\.com");
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

        sc = new Scanner(fileName);
        sc.useDelimiter("\\n{3}");
        while (sc.hasNext()) {
            wholemail.add(sc.next());
        }
    }

    public void splitMessage() {
        for (String e : wholemail) {
            sc = new Scanner(e);
            sc.useDelimiter("\\n{2}");
            int i=1;
            while (sc.hasNext()) {
                String message =sc.next();
                if (i == 2) {
                    splitMessage.add(message);
                    //mail.setMessagecontent(message);
                    System.out.println(message);
                }
                i++;
            }
        }
    }

    public void addMessagetoObject() {
        for (int i = 0; i <emailList.size ; i++) {
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
            System.out.println("Description: " + iter.getDescription());
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