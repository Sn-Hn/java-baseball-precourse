package baseball.model;

import java.util.List;

public class GameService {
  private final String RESTART_INPUT = "1";
  private final String RESTART_END = "2";

  public PlayResult startGame(Balls computerBalls, List<Integer> userNumber) {

    Balls userBalls = new Balls(userNumber);
    return userBalls.play(computerBalls);
  }

  public GameStatus restartOrEndGame(String restartInput) {
    validate(restartInput);
    if (RESTART_INPUT.equals(restartInput)) {
      return GameStatus.RESTART;
    }

    return GameStatus.END;
  }

  public void validate(String input) {
    if (!RESTART_INPUT.equals(input) && !RESTART_END.equals(input)) {
      throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
    }
  }
}
