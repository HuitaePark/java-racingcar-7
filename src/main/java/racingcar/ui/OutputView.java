package racingcar.ui;

import static racingcar.global.constant.GameMessage.GAME_RESULT_MESSAGE;
import static racingcar.global.constant.GameMessage.GAME_START_MESSAGE;

public class OutputView {
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameResultMessage(){
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printGameProgress(StringBuilder progressDetail){
        System.out.println(progressDetail);
    }
    public void printGameWinner(String winners){
        System.out.println();
    }
}
