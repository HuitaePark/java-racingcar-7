package racingcar.domain;

import static racingcar.global.util.Validator.validateComma;
import static racingcar.global.util.Validator.validateCount;
import static racingcar.global.util.Validator.validateParticipationListNumber;

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
        validateComma(participations,COMMA);
        validateCount(count);
        this.times = mapToInteger(count);
        this.carList = createCar(extractionParticipation(participations));
        this.race = race;
        this.winner = winner;
    }

    public StringBuilder gameStart() {
        return runRaceForGivenRounds();
    }

    public List<String> selectWinner(){
        return winner.findWinner(carList);
    }

    private List<Car> createCar(String[] participationList){
        validateParticipationListNumber(participationList);
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

    private StringBuilder runRaceForGivenRounds(){
        StringBuilder progress = new StringBuilder();

        for (int i = 0; i < times; i++) {
            race.runSingleRound(carList);
            race.updateProgress(carList, progress);
            progress.append("\n");
        }

        return progress;
    }

}
