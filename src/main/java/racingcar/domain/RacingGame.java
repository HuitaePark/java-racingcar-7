package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final String participations;
    private final String count;
    private String COMMA = ",";

    public RacingGame(String participations,String count) {
        this.participations = participations;
        this.count = count;
    }


    public void run() {
        int times = mapToInteger(count);
        List<Car> carList = createCar(times,extractionParticipation(participations));


    }

    private String[] extractionParticipation(String participations){
        return participations.split(COMMA);
    }

    private int mapToInteger(String count){
        return Integer.parseInt(count);
    }

    private List<Car> createCar(int num, String[] participationList){
        List<Car> carList = new ArrayList<>();

        for(int i = 0;i<num;i++){
            carList.add(new Car(participationList[i]));
        }
        return carList;
    }

}
