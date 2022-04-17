package baseball.view;

import baseball.model.BallStatus;
import baseball.model.PlayResult;

public class GameView {
  private static final String BLANK = "";
  private static final int ZERO = 0;

  public static String startGame() {
    print(Message.INPUT_NUMBER.getMessage());
    return InputNumber.input();
  }

  public static String endGame() {
    println(Message.RESTART_OR_END_GAME.getMessage());
    return InputNumber.input();
  }

  public static void endCompleteGame() {
    println(Message.COMPLETE_END_GAME.getMessage());
  }

  public static void error(String message) {
    println(message);
  }

  public static void hint(PlayResult playResult) {
    if (playResult.getBall() == ZERO && playResult.getStrike() == ZERO) {
      println(BallStatus.NOTHING.getStatus());
      return;
    }
    String result = mergeMessage(getBallMessage(playResult.getBall()), getStrikeMessage(playResult.getStrike()));
    println(result.trim());
  }

  private static String getStrikeMessage(int strike) {
    if (strike == ZERO) {
      return BLANK;
    }

    return mergeMessage(strike, BallStatus.STRIKE.getStatus());
  }

  private static String getBallMessage(int ball) {
    if (ball == ZERO) {
      return BLANK;
    }

    return mergeMessage(ball, BallStatus.BALL.getStatus());
  }

  private static String mergeMessage(Object count, String message) {
    return count + message;
  }

  public static void print(String message) {
    System.out.print(message);
  }

  public static void println(String message) {
    System.out.println(message);
  }
}
