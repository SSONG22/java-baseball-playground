package stringCalculator;

import java.sql.Struct;

public class StringCalculator {

    public static int isParsable(String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public static int plus(String a, String b) {
        return isParsable(a) + isParsable(b);
    }

    public static int minus(String a, String b) {
        return isParsable(a) - isParsable(b);
    }

    public static int divide(String a, String b) {
        return isParsable(a) / isParsable(b);
    }

    public static int multiply(String a, String b) {
        return isParsable(a) * isParsable(b);
    }

    public static int doingCalc(String op, String a, String b) {
        try {
            OperationType type = OperationType.getOperation(op);
            return type.getOperation().doing(a, b);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    public static int stringCalc(String input) {
        String[] arr = input.split(" ");
        String result = arr[0];
        int idx = 0;
        while (idx < arr.length-1) {
            result = String.valueOf(doingCalc(arr[idx+1], result, arr[idx+2]));
            idx+=2;
        }
        return isParsable(result);
    }
}
