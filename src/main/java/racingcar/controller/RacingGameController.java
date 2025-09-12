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

    public void gameStart() {
        RacingGame racingGame = setupGame();

        displayRacingGameProgress(racingGame);
        displayRacingGameWinner(racingGame);
    }

    private RacingGame setupGame(){
        String participations = inputHandler.inputText();
        outputView.printGameStartMessage();
        String count = inputHandler.inputText();

        return RacingGameCreator.createGame(participations, count);
    }

    private void displayRacingGameProgress(RacingGame racingGame){
        getGameProgress(racingGame.run());
    }

    private void getGameProgress(StringBuilder progressDetail){
        outputView.printGameResultMessage();
        outputView.printGameProgress(progressDetail);
    }

    private void displayRacingGameWinner(RacingGame racingGame){
        String gameWinners = getGameWinner(racingGame);
        outputView.printGameWinner(gameWinners);
    }

    private String getGameWinner(RacingGame racingGame) {
        return racingGame.selectWinner();
    }

}


