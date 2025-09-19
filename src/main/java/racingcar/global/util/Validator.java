package racingcar.global.util;

import static racingcar.global.exception.ErrorMessage.CAR_SIZE_ALONE;
import static racingcar.global.exception.ErrorMessage.COUNT_CONTAINS_STRING;
import static racingcar.global.exception.ErrorMessage.NAME_CONTAINS_NUMBER;
import static racingcar.global.exception.ErrorMessage.NAME_LENGTH_LIMIT_OVER;
import static racingcar.global.exception.ErrorMessage.PARTICIPATIONS_NOT_CONTAINS_COMMA;

public final class Validator {

    private Validator() {
    }

    public static void validateCount(String count){
        if(!count.matches("\\d+")){
            throw new IllegalArgumentException(COUNT_CONTAINS_STRING);
        }
    }

    public static void validateComma(String participations,String COMMA){
        if(!participations.contains(COMMA)){
            throw new IllegalArgumentException(PARTICIPATIONS_NOT_CONTAINS_COMMA);
        }
    }

    public static void validateParticipationListNumber(String[] participationList){
        if(participationList.length<1){
            throw new IllegalArgumentException(CAR_SIZE_ALONE);
        }
    }

    public static void validateNameLength(String name, int lengthLimit){
        if(name.length()>lengthLimit){
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_OVER);
        }
    }

    public static void validateNameNumber(String name){
        if(name.matches("-?[1-9]\\d*|0")){
            throw new IllegalArgumentException(NAME_CONTAINS_NUMBER);
        }
    }
}
