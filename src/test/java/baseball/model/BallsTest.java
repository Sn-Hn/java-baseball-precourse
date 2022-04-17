package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BallsTest {

    private Balls balls = new Balls(Arrays.asList(1, 2, 3));

    @Test
    void _1볼_1스트라이크_검증() {
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 3, 4)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(1),
                () -> assertThat(result.getBall()).isEqualTo(1),
                () -> assertThat(result.isEndGame()).isFalse()
        );
    }

    @Test
    void _3볼_검증() {
        PlayResult result = balls.play(new Balls(Arrays.asList(3, 1, 2)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(0),
                () -> assertThat(result.getBall()).isEqualTo(3),
                () -> assertThat(result.isEndGame()).isFalse()
        );
    }

    @Test
    void _3스트라이크_검증() {
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 2, 3)));

        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(3),
                () -> assertThat(result.getBall()).isEqualTo(0),
                () -> assertThat(result.isEndGame()).isTrue()
        );
    }

}
