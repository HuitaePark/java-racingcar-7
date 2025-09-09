package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final String participations;
    private final int times;
    private List<Car> carList = new ArrayList<>();
    private String COMMA = ",";

    public RacingGame(String participations,String count) {
        this.participations = participations;
        this.times = mapToInteger(count);
        carList = createCar(extractionParticipation(participations));
    }


    public StringBuilder run() {
        StringBuilder progress = new StringBuilder();

        for(int i = 0;i<times;i++){
            for(Car car : carList){
                runSingleRound();
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

    public int getMaxTravel(){
        return carList.stream()
                .mapToInt(Car::getTraveled)
                .max()
                .orElseThrow();
    }

    public List<String> getWinnerName(int maxTravel){
        return carList.stream()
                .filter(c->c.getTraveled()==maxTravel)
                .map(Car::getName)
                .toList();
    }

}
