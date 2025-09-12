package racingcar.ui;

import static racingcar.global.constant.GameMessage.GAME_RESULT_MESSAGE;
import static racingcar.global.constant.GameMessage.GAME_START_MESSAGE;
import static racingcar.global.constant.GameMessage.GAME_WINNER_MESSAGE;

import java.util.List;

public class OutputView {
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameResultMessage(){
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printGameProgress(StringBuilder progressDetail){
        System.out.print(progressDetail);
    }

    public void printGameWinner(List<String> winnerNames) {
        String winnerText = String.join(", ", winnerNames);
        System.out.println(GAME_WINNER_MESSAGE+winnerText);
    }

}
