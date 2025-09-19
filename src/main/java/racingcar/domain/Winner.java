package racingcar.domain;

import static racingcar.global.exception.ErrorMessage.WINNER_SIZE_ZERO;

import java.util.List;

public class Winner {

    public List<String> findWinner(List<Car> carList){
        int maxTravel = getMaxTravel(carList);
        return carList.stream()
                .filter(c->c.getTraveled()==maxTravel)
                .map(Car::getName)
                .toList();
    }

    private int getMaxTravel(List<Car> carList){
        return carList.stream()
                .mapToInt(Car::getTraveled)
                .max()
                .orElseThrow(()->new IllegalArgumentException(WINNER_SIZE_ZERO));
    }

    private List<String> getWinnerName(List<Car> carList,int maxTravel){
        return carList.stream()
                .filter(c->c.getTraveled()==maxTravel)
                .map(Car::getName)
                .toList();
    }
}
