package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @DisplayName("이름 분리 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni,jun"})
    public void inputTest(String input){

    }
}
