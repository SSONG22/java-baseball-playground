package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains(new String[]{"1", "2"});
    }

    @Test
    void 요구사항1_2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly(new String[]{"1"});
    }

    @Test
    void 요구사항2() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("StringIndexOutOfBoundsException 발생 확인")
    @Test
    void 요구사항3() {
        String input = "abc";
        int idx = 4;
        assertThatThrownBy(() -> input.charAt(idx))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
