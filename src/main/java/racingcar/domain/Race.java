package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    public StringBuilder raceResult(int times,List<Car> carList) {
        StringBuilder progress = new StringBuilder();

        for(int i = 0;i<times;i++){
            runSingleRound(carList);
            for(Car car : carList){
                progress.append(car.getName())
                        .append(" : ")
                        .append("-".repeat(car.getTraveled()))
                        .append("\n");
            }
            progress.append("\n");
        }
        return progress;
    }

    public void runSingleRound(List<Car> carList) {
        for (Car car : carList) {
            tryMove(car);
        }
    }

    private void tryMove(Car car){
        if(isMoveable(pickRandomNum())) {
            car.moveForward();
        }
    }

    private boolean isMoveable(int randomCount){
        return randomCount >= 4;
    }

    private int pickRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

}
