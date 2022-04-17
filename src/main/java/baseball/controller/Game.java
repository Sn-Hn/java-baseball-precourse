package baseball.controller;

import baseball.model.*;
import baseball.view.GameView;

import java.util.List;

public class Game {
  private final GameService gameService;
  private final ComputerNumber computerNumber = new ComputerNumber();

  private GameStatus gameStatus = GameStatus.RESTART;

  public Game(GameService gameService) {
    this.gameService = gameService;
  }

  public void run() {
    do {
      List<Integer> computerNumbers = computerNumber.createNumbers();
      Balls computerBalls = new Balls(computerNumbers);
      gameStatus = startGame(computerBalls);
    } while (gameStatus == GameStatus.RESTART);

    GameView.endCompleteGame();
  }

  public GameStatus startGame(Balls computerBalls) {
    PlayResult playResult = new PlayResult();

    while (!playResult.isEndGame()) {
      playResult = gameService.startGame(computerBalls, getUserNumber());
      GameView.hint(playResult);
    }

    return gameService.restartOrEndGame(GameView.endGame());
  }

  public List<Integer> getUserNumber() {
    List<Integer> userNumbers;
    UserNumber number = new UserNumber(GameView.startGame());
    userNumbers = number.createNumbers();

    return userNumbers;
  }
}
