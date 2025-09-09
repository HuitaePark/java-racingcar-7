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
                        .append("-".repeat(car.getTraveled()));
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
    public void getWinner() {

    }
}
