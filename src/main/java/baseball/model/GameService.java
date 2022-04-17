package baseball.model;

import java.util.List;

public class GameService {
  private final String RESTART_INPUT = "1";

  public PlayResult startGame(Balls computerBalls, List<Integer> userNumber) {

    Balls userBalls = new Balls(userNumber);
    return userBalls.play(computerBalls);
  }

  public GameStatus restartOrEndGame(String restartInput) {
    if (RESTART_INPUT.equals(restartInput)) {
      return GameStatus.RESTART;
    }

    return GameStatus.END;
  }
}
