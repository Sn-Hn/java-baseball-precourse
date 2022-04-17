package baseball.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a2", "012", "asd", "12^", "qqf3w4q5qf"})
    void 숫자_범위_검증_오류(String input) {
        ThrowableAssert.ThrowingCallable validation = () -> new UserNumber(input);;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(validation);
    }

    @Test
    void 숫자_길이_검증_오류() {
        String input = "1234";
        ThrowableAssert.ThrowingCallable validation = () -> new UserNumber(input);;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(validation);
    }

    @Test
    void 숫자_중복_검증_오류() {
        String input = "121";

        ThrowableAssert.ThrowingCallable validation = () -> new UserNumber(input);;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(validation);
    }
}
