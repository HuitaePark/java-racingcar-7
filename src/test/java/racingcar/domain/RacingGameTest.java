package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.util.RacingGameCreator;

public class RacingGameTest {

    @DisplayName("게임 진행 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni,jun"})
    public void game_process_test(String input){
        RacingGame racingGame = RacingGameCreator.createGame(input,"5");
        StringBuilder run = racingGame.run();

        assertThat(run)
                .contains("pobi :")
                .contains("woni :")
                .contains("jun :");
    }

    @DisplayName("글자가 숫자일시 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi,woni,jun"})
    public void count_contains_string_Test(String input){
        assertThatThrownBy(()-> {
            RacingGame racingGame = RacingGameCreator.createGame(input,"십");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수에 숫자가 아닌걸 입력할순 없습니다.");
    }

    @DisplayName("참가자 입력 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "pobi/woni/jun"})
    public void validate_participations_Test(String input){
        assertThatThrownBy(()-> {
            RacingGame racingGame = RacingGameCreator.createGame(input,"5");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 콤마로 구분해야 합니다.");
    }

}
