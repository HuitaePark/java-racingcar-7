package racingcar.domain;

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


    }

    private String[] extractionParticipation(String participations){
        return participations.split(COMMA);
    }

    private int mapToInteger(String count){
        return Integer.parseInt(count);
    }

}
