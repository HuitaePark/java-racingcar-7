package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.global.util.RacingGameCreator;
import racingcar.ui.InputHandler;
import racingcar.ui.OutputView;

public class RacingGameController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public RacingGameController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void gameStart(){
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
