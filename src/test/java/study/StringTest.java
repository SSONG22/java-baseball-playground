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
    void return_integer() {
        String actual = "(1,2)".replace("(","").replace(")","");
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다.")
    @Test
    void get_char(){
        String given = "abcd";
        assertThat(given.charAt(0)).isEqualTo('a');
        assertThat(given.charAt(1)).isEqualTo('b');
    }

    @DisplayName("인덱스 범위 바깥에는 IndexOutOfBoundsException 예외가 발생한다.")
    @Test
    void get_char_exception(){
        assertThatThrownBy(() -> {
            "abcd".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
