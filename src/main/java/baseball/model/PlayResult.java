package baseball.model;

public class PlayResult {

  private static final int ZERO = 0;
  private static final int END_GAME = 3;
  private static final String BLANK = "";

  private int strike = ZERO;
  private int ball = ZERO;

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  public void increaseCount(BallStatus status) {
    if (status == BallStatus.STRIKE) {
      strike ++;
    }

    if (status == BallStatus.BALL) {
      ball ++;
    }
  }

  public boolean isEndGame() {
    if (strike == END_GAME) {
      return true;
    }

    return false;
  }
}
