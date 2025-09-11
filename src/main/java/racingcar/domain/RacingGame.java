package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final int times;
    private List<Car> carList = new ArrayList<>();
    private final String COMMA = ",";

    public RacingGame(String participations,String count) {
        this.times = mapToInteger(count);
        carList = createCar(extractionParticipation(participations));
    }


    public StringBuilder run() {
        Race race = new Race();
        return race.raceResult(times,carList);
    }

    private String[] extractionParticipation(String participations){
        return participations.split(COMMA);
    }

    private int mapToInteger(String count){
        return Integer.parseInt(count);
    }

    private List<Car> createCar(String[] participationList){
        return Arrays.stream(participationList)
                .map(Car::new)
                .toList();
    }


    public String getWinner(){
        int maxTravel = getMaxTravel();
        List<String> winnerList = getWinnerName(maxTravel);
        StringBuilder winners = new StringBuilder();
        if(winnerList.size()>1) {

            for (int i = 0; i < winnerList.size() - 1; i++) {
                winners.append(winnerList.get(i))
                        .append(", ");

            }
            winners.append(winnerList.getLast());
            return winners.toString();
        }

        return winnerList.getLast();
    }

    private int getMaxTravel(){
        return carList.stream()
                .mapToInt(Car::getTraveled)
                .max()
                .orElseThrow();
    }

    private List<String> getWinnerName(int maxTravel){
        return carList.stream()
                .filter(c->c.getTraveled()==maxTravel)
                .map(Car::getName)
                .toList();
    }
}
