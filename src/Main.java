import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
    
            public static String _split(String string){
                String result_spl[] = string.split(" ");
                for (int i = 0; i < result_spl.length; i++){
                    if (result_spl[i].contains("@")){
                        return result_spl[i];
                    }
                }
                return "succes";
            }
        }
}}

        /*// handle user commands
        boolean quit = false;
        int menuItem;
        do {
            System.out.print("Choose menu item: ");
            Menu.PrintMenu();
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("You've chosen item #1");
                    // do something...
                    break;
                case 2:
                    System.out.println("You've chosen item #2");
                    // do something...
                    break;
                case 3:
                    System.out.println("You've chosen item #3");
                    // do something...
                    break;
                case 4:
                    System.out.println("You've chosen item #4");
                    // do something...
                    break;
                case 5:
                    System.out.println("You've chosen item #5");
                    // do something...
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println("Exiting main loop!");
    }


}*/