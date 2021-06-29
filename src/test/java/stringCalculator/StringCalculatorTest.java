package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("숫자인지 확인하는 메서드")
    @Test
    void validation() {
        assertThatThrownBy(() -> StringCalculator.isParsable("a"))
                .isInstanceOf(NumberFormatException.class);
    }

    // (a, b) -> (a+b)
    @Test
    void 더하기() {
        assertThat(StringCalculator.plus("1", "2")).isEqualTo(3);
    }

    @Test
    void 빼기() {
        assertThat(StringCalculator.minus("1", "3")).isEqualTo(-2);
    }

    @Test
    void 나누기() {
        assertThat(StringCalculator.divide("8", "4")).isEqualTo(2);
    }

    @Test
    void 곱하기() {
        assertThat(StringCalculator.multiply("1", "4")).isEqualTo(4);
    }

    @Test
    void enum_테스트() {
        assertThat(OperationType.getOperation("+")).isEqualTo(OperationType.PLUS);
        assertThat(OperationType.getOperation("-")).isEqualTo(OperationType.MINUS);
        assertThat(OperationType.getOperation("*")).isEqualTo(OperationType.MULTIPLY);
        assertThat(OperationType.getOperation("/")).isEqualTo(OperationType.DIVIDE);
    }

    @DisplayName("연산자 포함 계산")
    @Test
    void checkOperation() {
        assertThat(StringCalculator.doingCalc("+", "2", "3")).isEqualTo(5);
        assertThat(StringCalculator.doingCalc("-", "1", "2")).isEqualTo(-1);
        assertThat(StringCalculator.doingCalc("*", "1", "2")).isEqualTo(2);
        assertThat(StringCalculator.doingCalc("/", "3", "1")).isEqualTo(3);
    }

    @DisplayName("input 나누기")
    @Test
    void 문자열계산() {
        assertThat(StringCalculator.stringCalc("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(StringCalculator.stringCalc("2 + 3 * 4 + 2")).isEqualTo(22);
        assertThat(StringCalculator.stringCalc("2 + 3 * 4")).isEqualTo(20);
        assertThat(StringCalculator.stringCalc("2 * 4 / 2")).isEqualTo(4);
        assertThat(StringCalculator.stringCalc("2 - 2")).isEqualTo(0);
    }
}
