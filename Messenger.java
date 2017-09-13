package com.company;

import java.util.ArrayList;

public class Messenger {

    public void criticalErrorRaport(String msg) {
        System.out.println(colorList.RED + "=================================================");
        System.out.println(colorList.RED + "=   PROGRAM STOPED! SOMTHING TERRIBLE HAPPENED! =");
        System.out.println(colorList.RED + "=================================================");
        System.out.println(colorList.YELLOW + "Additional info: " + msg + colorList.RESET);
    }

    public void warningErrorReport( String msg) {
        System.out.println(colorList.YELLOW + "=================================================");
        System.out.println(colorList.YELLOW + "=   WARNING! SOMTHING STRANGE HAPPENED!         =");
        System.out.println(colorList.YELLOW + "=================================================");
        System.out.println(colorList.GREEN + "Additional info: " + msg + colorList.RESET);
    }

    public void printResult(ArrayList<String> in) {
        for (String s : in) {

        }
    }
}
