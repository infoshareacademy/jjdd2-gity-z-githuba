package pl.infoshareacademy.mail;

public class Menu {
    public static void PrintMenu(){
        System.out.println("Welcome @User! How can I help you?");
        System.out.println("");
        System.out.format("%-60s - AVALIBLE%n","1. What keywords should I use to find my email?");
        System.out.format("%-60s - AVALIBLE%n","2. Analyse contact data from my email");
        System.out.format("%-60s - UNAVALIBLE%n","3. Show me my top 10 customers");
        System.out.format("%-60s - AVALIBLE%n","4. Filter my contacts (Single .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","5. Filter my contacts (Multiple .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","6. Show me abandoned customers");
        System.out.println();
        System.out.println("0. Quit");
    } // Function that prints menu on the screen

     public static void PrintMenuAnalyze(){
        Messenger msg = new Messenger();
        msg.warningErrorReport("Function not done yet!");
    }


}
