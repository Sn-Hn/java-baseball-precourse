package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

  @Test
  void Set_크기_검증() {
    Assertions.assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void Set_값_검증(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
  @DisplayName("입력 값에 따라 결과 값이 다른 경우를 확인한다.")
  void Set_기대_값_검증(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
