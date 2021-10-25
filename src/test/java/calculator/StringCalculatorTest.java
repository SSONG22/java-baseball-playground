package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("입력값 유효성 체크 - null 이나 빈값이 오면 IllegalArgumentException 에러가 발생한다.")
    @Test
    void input(String input) {
        assertThatThrownBy(() -> {
            StringCalculator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값을 입력하였습니다.");
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "4 + 1 * 3 / 1:15"}, delimiter = ':')
    void 사칙연산(String input, long expect) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expect);
    }

}