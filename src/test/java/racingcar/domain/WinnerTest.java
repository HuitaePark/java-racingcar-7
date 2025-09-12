package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    @DisplayName("우승자 수 에러 테스트")
    @Test
    public void carMoveTest(){
        assertThatThrownBy(()-> {
            Winner winner = new Winner();
            List<Car> carList = new ArrayList<>();
            winner.findWinner(carList);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("우승자의 수는 한명 이상입니다.");
    }
}
