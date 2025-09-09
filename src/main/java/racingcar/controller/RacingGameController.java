package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.ui.InputHandler;
import racingcar.ui.OutputView;

public class RacingGameController {
    public void gameStart(){
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();

        String participations = inputHandler.inputText();
        outputView.printGameStartMessage();
        String count = inputHandler.inputText();

        RacingGame racingGame = new RacingGame(participations,count);
        racingGame.run();
    }
}
