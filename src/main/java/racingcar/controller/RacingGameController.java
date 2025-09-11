package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.global.util.RacingGameCreator;
import racingcar.ui.InputHandler;
import racingcar.ui.OutputView;

public class RacingGameController {
    public void gameStart(){
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();

        String participations = inputHandler.inputText();
        outputView.printGameStartMessage();
        String count = inputHandler.inputText();

        RacingGame racingGame = RacingGameCreator.createGame(participations,count);

        StringBuilder progressDetail = racingGame.run();
        outputView.printGameResultMessage();
        outputView.printGameProgress(progressDetail);

        String gameWinners = racingGame.selectWinner();
        outputView.printGameWinner(gameWinners);
    }
}
