package calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        String input = Input.inputString();
        Long value = StringCalculator.calculate(input);
        System.out.println(value);
    }
}
