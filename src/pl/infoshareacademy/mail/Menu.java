public class Menu {
    public static void PrintMenu(){
        /*Zastosowane formatowanie stringów dla łatdniejszego wyglądu.
        %-60s oznacza zareserwowanie 60 znaków do lewej dla danego stringa. Pozwala to stworzyć swego rodzaju tebele.
        Przykładowy kod pozwalający lepiej to zrozumieć:


        List<String> listBook = Arrays.asList(
                "Head First Java",
                "Effective Java",
                "The Passionate Programmer",
                "Head First Design Patterns"
        );
        for (String book : listBook) {
            System.out.format("%-30s - In Stock%n", book);
        }*/

        System.out.println("Welcome @User! How i can help you?");
        System.out.println("");
        System.out.format("%-60s - UNAVALIBLE%n","1. What keywords should i use to find mine email?");
        System.out.format("%-60s - UNAVALIBLE%n","2. Analyze contact data from mine e-mail");
        System.out.format("%-60s - UNAVALIBLE%n","3. Show me mine top 10 customer's");
        System.out.format("%-60s - UNAVALIBLE%n","4. Filter mine contact's (Single .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","5. Filter mine contact's (Multiple .mbox file)");
        System.out.format("%-60s - UNAVALIBLE%n","6. Show me abandoned customers");
        System.out.println();
        System.out.println("0. Quit");
    } // Function that prints menu on the screen
}
