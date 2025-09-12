package racingcar.domain;

import static racingcar.global.exception.ErrorMessage.COUNT_CONTAINS_STRING;
import static racingcar.global.exception.ErrorMessage.PARTICIPATIONS_NOT_CONTAINS_COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final int times;
    private final Race race;
    private final Winner winner;

    private List<Car> carList = new ArrayList<>();
    private final String COMMA = ",";

    public RacingGame(String participations,String count,Race race, Winner winner) {
        validateComma(participations);
        validateCount(count);
        this.times = mapToInteger(count);
        this.carList = createCar(extractionParticipation(participations));
        this.race = race;
        this.winner = winner;
    }

    public StringBuilder run() {
        return race.raceResult(times,carList);
    }

    public String selectWinner(){
        return winner.getWinner(carList);
    }

    private List<Car> createCar(String[] participationList){
        return Arrays.stream(participationList)
                .map(Car::new)
                .toList();
    }

    private String[] extractionParticipation(String participations){
        return participations.split(COMMA);
    }

    private int mapToInteger(String count){
        return Integer.parseInt(count);
    }

    private void validateCount(String count){
        if(!count.matches("\\d+")){
            throw new IllegalArgumentException(COUNT_CONTAINS_STRING);
        }
    }

    private void validateComma(String participations){
        if(participations.contains(COMMA)){
            throw new IllegalArgumentException(PARTICIPATIONS_NOT_CONTAINS_COMMA);
        }
    }
}
