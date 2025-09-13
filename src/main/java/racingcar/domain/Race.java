package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    private final int PROCEEDING = 4;

    public void runSingleRound(List<Car> carList) {
        for (Car car : carList) {
            tryMove(car);
        }
    }

    public void updateProgress (List <Car> carList, StringBuilder progress){
        for (Car car : carList) {
            progress.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getTraveled()))
                    .append("\n");
        }
    }

    private void tryMove (Car car){
        if (isMoveable(pickRandomNum())) {
            car.moveForward();
        }
    }

    private boolean isMoveable ( int randomCount){
        return randomCount >= PROCEEDING;
    }

    private int pickRandomNum () {
        return Randoms.pickNumberInRange(0, 9);
    }

}
