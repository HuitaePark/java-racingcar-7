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
        StringBuilder progress = new StringBuilder();

        for(int i = 0;i<times;i++){
            runSingleRound();
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

    public void runSingleRound() {
        for (Car car : carList) {
            tryMove(car);
        }
    }

    private void tryMove(Car car){
        if(isMoveable(pickRandomNum())) {
            car.moveForward();
        }
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

    private boolean isMoveable(int randomCount){
        return randomCount >= 4;
    }

    private int pickRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }
}
