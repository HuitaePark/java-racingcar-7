package racingcar.global.util;

import racingcar.domain.Race;
import racingcar.domain.RacingGame;
import racingcar.domain.Winner;

public class RacingGameCreator {
    public static RacingGame createGame(String participations,String count){
        Race race = new Race();
        Winner winner = new Winner();
        return new RacingGame(participations,count,race,winner);
    }
}
