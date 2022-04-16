package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

  @Test
  void String_분리_검증_1() {
    String testStr = "1,2";

    assertThat(testStr.split(",")).containsOnly("1", "2");
  }

  @Test
  void String_분리_검증_2() {
    String testStr = "1";

    assertThat(testStr.split(",")).containsExactly("1");
  }

  @Test
  void String_추출_검증() {
    String testStr = "(1,2)";

    assertThat(testStr.substring(1, testStr.length() - 1)).isEqualTo("1,2");
  }

  @ParameterizedTest
  @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
  void String_특정_위치_문자_검증(int inputIndex, char expected) {
    String testStr = "abc";

    assertThat(testStr.charAt(inputIndex)).isEqualTo(expected);
  }

  @Test
  void String_특정_위치_검증_오류() {
    String testStr = "abc";

    ThrowableAssert.ThrowingCallable outOfPosition = () -> testStr.charAt(3);

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(outOfPosition)
            .withMessageMatching("String index out of range: 3");
  }
}
