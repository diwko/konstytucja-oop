package constitution;

public class Main {

    public static void main(String[] args) {
        try {
            ConstitutionPrinter printer = new ConstitutionPrinter(args);
            printer.print();
        } catch (IllegalArgumentException e) {
            System.out.println("Nieprawidłowe argumenty");
        }
    }
}
