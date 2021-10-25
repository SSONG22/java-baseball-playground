package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperationTest {

    @ParameterizedTest
    @CsvSource(value = {"2:5:7", "1:3:4", "-3:1:-2"}, delimiter = ':')
    void 덧셈(int a, int b, int c) {
        assertThat(Operation.PLUS.calculate(a, b)).isEqualTo(c);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:5:-3", "4:3:1", "-3:1:-4"}, delimiter = ':')
    void 뺄셈(int a, int b, int c) {
        assertThat(Operation.MINUS.calculate(a, b)).isEqualTo(c);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:5:10", "10000:3:30000", "-3:1:-3"}, delimiter = ':')
    void 곱셈(int a, int b, int c) {
        assertThat(Operation.MULTIPLY.calculate(a, b)).isEqualTo(c);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5:1", "4:1:4", "1:1:1"}, delimiter = ':')
    void 나눗셈(int a, int b, int c) {
        assertThat(Operation.MINUS.calculate(a, b)).isEqualTo(c);
    }

    @Test
    void 연산_success() {
        assertThat(Operation.findOperation("+")).isEqualTo(Operation.PLUS);
        assertThat(Operation.findOperation("-")).isEqualTo(Operation.MINUS);
        assertThat(Operation.findOperation("*")).isEqualTo(Operation.MULTIPLY);
        assertThat(Operation.findOperation("/")).isEqualTo(Operation.DIVIDE);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void 연산_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.findOperation("."));
    }

}