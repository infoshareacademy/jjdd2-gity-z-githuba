package com.company;

import com.company.Messenger;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Messenger msg = new Messenger();
        Scanner in = new Scanner(System.in);
        System.out.println();
        // handle user commands
        boolean quit = false;
        int menuItem;
        do {
            Menu.PrintMenu();
            System.out.print("Choose menu item: ");
            while (!in.hasNextInt()) {
                System.out.println("This is invalid choice!");
                in.next();
            }
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("You've chosen item #1");
                    Menu.PrintMenuKeywords();
                    break;
                case 2:
                    System.out.println("You've chosen item #2");
                    Menu.PrintMenuAnalyze();
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
}
