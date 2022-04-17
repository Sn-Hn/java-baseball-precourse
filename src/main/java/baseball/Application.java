package baseball;

import baseball.controller.Game;
import baseball.model.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(new GameService());
        game.run();
    }
}
