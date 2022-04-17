package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerNumberTest {

    private ComputerNumber computerNumber = new ComputerNumber();

    @Test
    void 난수_생성_검증() {
        List<Integer> randomNumbers = computerNumber.createNumbers();

        assertThat(randomNumbers.size()).isEqualTo(3);
    }
}
