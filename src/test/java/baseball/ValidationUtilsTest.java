package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @Test
    @DisplayName("숫자 1~9 검증")
    void 숫자검증(){
        assertThat(ValidationUtils.validNumber(9)).isTrue();
        assertThat(ValidationUtils.validNumber(1)).isTrue();
        assertThat(ValidationUtils.validNumber(0)).isFalse();
    }

}