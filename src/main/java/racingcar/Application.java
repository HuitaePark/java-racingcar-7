package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.ui.InputHandler;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();

        RacingGameController controller = new RacingGameController(inputHandler,outputView);
        controller.gameStart();
    }
}
