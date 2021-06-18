package stringCalculator;

public enum Operation {
    PLUS {
        @Override
        int doing(String a, String b) {
            return plus(a, b);
        }
    }, MINUS {
        @Override
        int doing(String a, String b) {
            return minus(a, b);
        }
    }, MULTIPLY {
        @Override
        int doing(String a, String b) {
            return multiply(a, b);
        }
    }, DIVIDE {
        @Override
        int doing(String a, String b) {
            return divide(a, b);
        }
    };


    abstract int doing(String a, String b);

    public int isParsable(String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public int plus(String a, String b) {
        return isParsable(a) + isParsable(b);
    }

    public int minus(String a, String b) {
        return isParsable(a) - isParsable(b);
    }

    public int divide(String a, String b) {
        return isParsable(a) / isParsable(b);
    }

    public int multiply(String a, String b) {
        return isParsable(a) * isParsable(b);
    }
}
