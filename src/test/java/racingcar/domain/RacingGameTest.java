package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.util.RacingGameCreator;

public class RacingGameTest {

    @DisplayName("승리자 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni,jun"})
    public void inputTest(String input){
        RacingGame racingGame = RacingGameCreator.createGame(input,"5");
    }
}
