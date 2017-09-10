package src;

import java.util.Scanner;

public class KeyWords_2 {

    public static void main(String[] args) {

        Scanner  scanner = new Scanner(System.in);

            System.out.println("Czy email jest pilny? (T)ak/(N)ie");

            String pytanie1;
            pytanie1 = scanner.nextLine().toLowerCase();
            while (!(pytanie1.equals("t")|| pytanie1.equals("n"))) {
                System.out.println("Wpisz (T)ak lub (N)ie");
                pytanie1 = scanner.nextLine().toLowerCase();
            }
                switch (pytanie1) {
                    case "t":
                        System.out.println();
                        System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                                "\n" + "-pilny" + "\n" + "-szybko" + "\n" + "-wczoraj" + "\n" + "-dzisiaj" + "\n" + "-ASAP" + "\n" + "-bezzwłocznie");
                        break;
                    case "n":
                        System.out.println();
                        System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                                "\n" + "-nieważne" + "\n" + "-dawno" + "\n" + "-jutro" + "\n" + "-później");
                        break;
                }

            System.out.println();
            System.out.println("Czy jest to email służbowy? (T)ak/(N)ie");

            String pytanie2;
            pytanie2 = scanner.nextLine().toLowerCase();
            while (!(pytanie2.equals("t")|| pytanie2.equals("n"))) {
                System.out.println("Wpisz (T)ak lub (N)ie");
                pytanie2 = scanner.nextLine().toLowerCase();
            }
                switch (pytanie2) {
                    case "t":
                        System.out.println();
                        System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                                "\n" + "-dzień dobry" + "\n" + "-witam" + "\n" + "-pozdrawiam" + "\n" + "-żegnam" + "\n" + "-do widzenia");
                        break;
                    case "n":
                        System.out.println();
                        System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                                "\n" + "-cześć" + "\n" + "-hej" + "\n" + "-dzięki" + "\n" + "-na razie");
                        break;
                }

            System.out.println();
            System.out.println("Czy ten email jest ważny? (T)ak/(N)ie");

            String pytanie3;
            pytanie3 = scanner.nextLine().toLowerCase();
            while (!(pytanie3.equals("t")|| pytanie3.equals("n"))) {
                System.out.println("Wpisz (T)ak lub (N)ie");
                pytanie3 = scanner.nextLine().toLowerCase();
            }
            switch (pytanie3){
                case "t":
                    System.out.println();
                    System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                            "\n" + "-ważne" + "\n" +"-istotne" + "\n" +"-koniecznie" + "\n" +"-obowiazkowo"+ "\n" +"-obligatoryjnie");
                    break;
                case "n":
                    System.out.println();
                    System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                            "\n" + "-nieważne" + "\n" +"-nieistotne"+ "\n" +"-btw"+ "\n" +"-przy okazji");
                    break;
            }
        System.out.println();
        System.out.println("Cieszę się, żę mogłem pomóc!");
    }
}
