package racingcar.domain;

import java.util.List;

public class Winner {

    public String getWinner(List<Car> carList){
        int maxTravel = getMaxTravel(carList);
        List<String> winnerList = getWinnerName(carList,maxTravel);

        if(isSeveralPeople(winnerList)) {
            return getWinnerNames(winnerList);
        }

        return winnerList.getLast();
    }

    private int getMaxTravel(List<Car> carList){
        return carList.stream()
                .mapToInt(Car::getTraveled)
                .max()
                .orElseThrow();
    }

    private List<String> getWinnerName(List<Car> carList,int maxTravel){
        return carList.stream()
                .filter(c->c.getTraveled()==maxTravel)
                .map(Car::getName)
                .toList();
    }

    private boolean isSeveralPeople(List<String> winnerList){
        return winnerList.size()>1;
    }

    private String getWinnerNames(List<String> winnerList){
        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < winnerList.size() - 1; i++) {
            winners.append(winnerList.get(i))
                    .append(", ");

        }
        winners.append(winnerList.getLast());

        return winners.toString();
    }
}
