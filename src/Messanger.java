import java.util.InputMismatchException;
import java.util.Scanner;

public class Messanger {
    public void errorMsg(String msg) {
        System.out.println(ColorList.RED.getColor() + " =====================================================" + ColorList.RESET.getColor());
        System.out.println(ColorList.RED.getColor() + " =         CRITICAL ERROR! PROGRAM WILL BE HALTED!   =" + ColorList.RESET.getColor());
        System.out.println(ColorList.RED.getColor() + " =====================================================" + ColorList.RESET.getColor());
        System.out.println(ColorList.YELLOW.getColor() + "Additional Info: " + msg  + ColorList.RESET.getColor());
    }

    public void warningMsg(String msg) {
        System.out.println(ColorList.YELLOW.getColor() + " =====================================================" + ColorList.RESET.getColor());
        System.out.println(ColorList.YELLOW.getColor() + " =         CRITICAL ERROR! PROGRAM WILL BE HALTED!   =" + ColorList.RESET.getColor());
        System.out.println(ColorList.YELLOW.getColor() + " =====================================================" + ColorList.RESET.getColor());
        System.out.println(ColorList.PURPLE.getColor() + "Additional Info: " + msg  + ColorList.RESET.getColor());
    }

    public Integer scannerIntChecker() {
        /*Integer menuInt;
        System.out.println("Please select menu item: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()); {
            System.out.println("Invalid choose! Please select number!");
            scanner.next();
        }
        menuInt = scanner.nextInt();
        System.out.println("Result: " + menuInt);
        return menuInt;*/
        int usrInput = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("What can i do for you?");
        /*try {
            System.out.print("Podaj wybór: ");
            usrInput = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Not an integer value!");
        }*/
        while (!sc.hasNextInt()) {
            System.out.println("Invalid choice! Please provide integer value!");
            sc.next();
        }
        return usrInput;
    }
}

