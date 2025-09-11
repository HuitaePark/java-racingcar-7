package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차의 전진 테스트")
    @Test
    public void carMoveTest(){
        Car car = new Car("test");
        car.moveForward();
        assertThat(car.getTraveled()).isEqualTo(1);
    }

    @DisplayName("글자수 초과시 에러 테스트")
    @Test
    public void validate_Name_Test(){
        assertThatThrownBy(()-> {
            Car car = new Car("testCar");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 제한 길이 (5)글자를 초과하였습니다.");
    }

}
