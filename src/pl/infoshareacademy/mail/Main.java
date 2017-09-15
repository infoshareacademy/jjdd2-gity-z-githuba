package pl.infoshareacademy.mail;


public class Main {
    public static void main(String[] args) throws Exception {

//        String sampleMailHeaders = "From: Angus W Hardie <Angus.Hardie@malcolmhardie.com>";
//
//        openFiletest openFiletest = new openFiletest("/home/michalrichert/Downloads/testlist.mbox");
//        openFiletest.message();
//        // System.out.println(openFiletest.maillist.get(0).toString());
//        openFiletest.splitMessage();
//        openFiletest.splitMessage1();
//        MailProcessor mp = new MailProcessor(openFiletest.maillist.get(0).getMessage());
//        ParsedMail result = mp.process();
//        System.out.println(result);
        Finder mail = new Finder();
        mail.findEmailAndDescription("/home/michalrichert/Downloads/testlist.mbox");
        mail.displayAllEmails();

    }
}