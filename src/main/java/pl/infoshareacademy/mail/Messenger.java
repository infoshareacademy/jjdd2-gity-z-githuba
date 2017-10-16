package pl.infoshareacademy.mail;

public class Messenger {

    public void criticalErrorRaport(String msg) {
        System.out.println(ColorList.RED + "=================================================");
        System.out.println(ColorList.RED + "= PROGRAM STOPPED! SOMETHING TERRIBLE HAPPENED! =");
        System.out.println(ColorList.RED + "=================================================");
        System.out.println(ColorList.YELLOW + "Additional info: " + msg + ColorList.RESET);
    }

    public void warningErrorReport( String msg) {
        System.out.println(ColorList.YELLOW + "=================================================");
        System.out.println(ColorList.YELLOW + "=  WARNING! SOMETHING STRANGE HAPPENED!         =");
        System.out.println(ColorList.YELLOW + "=================================================");
        System.out.println(ColorList.GREEN + "Additional info: " + msg + ColorList.RESET);
    }
}
