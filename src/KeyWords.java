import java.util.Scanner;

public class KeyWords {

    public static void main(String[] args) {

        System.out.println("Czy email jest pilny?" + "\n" +"1.Tak, jest pilny."+ "\n" +"2.Nie, nie jest pilny.");

        Scanner  scanner = new Scanner(System.in);

        int odpowiedz;
        odpowiedz = scanner.nextInt();

        switch (odpowiedz){
            case 1:
                System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                    "\n" + "-pilny" + "\n" +"-szybko" + "\n" +"-wczoraj" + "\n" +"-dzisiaj"+ "\n" +"-ASAP");
            break;
            case 2:
            System.out.println("Słowa kluczowe, które mogą być dla Ciebie pomocne to:" +
                    "\n" + "-nieważne" + "\n" +"-dawno"+ "\n" +"-jutro"+ "\n" +"-później");
            break;
            default:
                System.out.println("Wybierz opcję 1 lub 2");
        }

    }
}
