package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();
        controller.gameStart();
    }
}
