package baseball.model;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayResultTest {

    private PlayResult playResult;

    @BeforeAll
    void setUp() {
        playResult = new PlayResult();
    }

    @Order(1)
    @Test
    void 스트라이크_증가_검증() {
        playResult.increaseCount(BallStatus.STRIKE);

        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Order(2)
    @Test
    void 볼_증가_검증() {
        playResult.increaseCount(BallStatus.BALL);

        assertThat(playResult.getBall()).isEqualTo(1);
    }

    @Order(3)
    @Test
    void 게임_종료_실패() {
        assertThat(playResult.isEndGame()).isFalse();
    }

    @Order(4)
    @Test
    void 게임_종료_성공() {
        while (playResult.getStrike() < 3) {
            playResult.increaseCount(BallStatus.STRIKE);
        }

        assertThat(playResult.isEndGame()).isTrue();
    }
}