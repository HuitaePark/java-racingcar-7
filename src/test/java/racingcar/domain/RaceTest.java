package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @DisplayName("자동차 수 에러 테스트")
    @Test
    public void carMoveTest(){
        assertThatThrownBy(()-> {
            Race race = new Race();
            List<Car> carList = new ArrayList<>();
            race.raceResult(2,carList);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 두대 이상을 입력해야 게임을 진행할 수 있습니다.");
    }
}
