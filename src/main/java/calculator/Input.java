package calculator;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private Input(){}

    public static String inputString() {
        String input = scanner.nextLine();
        return input;
    }

}
