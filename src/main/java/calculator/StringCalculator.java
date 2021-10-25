package calculator;

public class StringCalculator {

    private StringCalculator() {
    } // util 객체 이므로 생성자를 막아준다

    public static void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다.");
        }
    }

    public static long calculate(final String input) {
        validate(input);
        String[] numbers = input.split(" ");
        long x = Long.parseLong(numbers[0]);
        for (int i = 1; i < numbers.length; i += 2) {
            Operation operation = Operation.findOperation(numbers[i]);
            long y = Long.parseLong(numbers[i + 1]);
            x = operation.calculate(x, y);
        }
        return x;
    }
}
