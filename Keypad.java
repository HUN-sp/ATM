import java.util.Scanner;

public class Keypad {
    private final Scanner scanner = new Scanner(System.in);
    public String getInput() {
        System.out.print("INPUT: ");
        return scanner.nextLine();
    }
}

