package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private final Ball ball = new Ball(1, 2);

    @Test
    void 스트라이크_검증() {
        BallStatus status = ball.play(new Ball(1, 2));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼_검증() {
        BallStatus status = ball.play(new Ball(2, 2));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱_검증() {
        BallStatus status = ball.play(new Ball(2, 3));

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
