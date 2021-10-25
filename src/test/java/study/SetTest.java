package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @DisplayName("요구사항1 - set의 크기를 확인한다.")
    @Test
    void set_size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2 - ParameterizedTest 를 사용해 중복을 제거한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항3 -")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int number, boolean expected) {
        boolean actualValue = numbers.contains(number);
        assertEquals(expected, actualValue);
    }

}