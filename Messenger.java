package com.company;

public class Messenger {

    public void criticalErrorRaport(String msg) {
        System.out.println(colorList.RED + "=================================================");
        System.out.println(colorList.RED + "=   PROGRAM STOPED! SOMTHING TERRIBLE HAPPENED! =");
        System.out.println(colorList.RED + "=================================================");
        System.out.println(colorList.YELLOW + "Additional info: " + msg + colorList.RESET);
    }



}
