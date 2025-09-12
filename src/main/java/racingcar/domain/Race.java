package racingcar.domain;

import static racingcar.global.exception.ErrorMessage.CAR_SIZE_ALONE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    public StringBuilder raceResult(int times,List<Car> carList) {
        StringBuilder progress = new StringBuilder();
        validateCarListNumber(carList);

        for(int i = 0;i<times;i++){
            runSingleRound(carList);
            updateProgress(carList,progress);
            progress.append("\n");
        }
        return progress;
    }

    public void runSingleRound(List<Car> carList) {
        for (Car car : carList) {
            tryMove(car);
        }
    }
    private void updateProgress(List<Car> carList,StringBuilder progress){
        for(Car car : carList){
            progress.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getTraveled()))
                    .append("\n");
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

    private void validateCarListNumber(List<Car> carList) {
        if(carList.size()<=1){
            throw new IllegalArgumentException(CAR_SIZE_ALONE);
        }
    }
}
