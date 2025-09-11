package racingcar.domain;

import static racingcar.global.exception.ErrorMessage.NAME_LENGTH_LIMIT_OVER;

public class Car {
    private final String name;
    private final Position position;
    private final int lengthLimit = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = new Position();
    }

    public void moveForward(){
            position.increaseValue();
    }

    public int getTraveled() {
        return position.getValue();
    }

    public String getName() {
        return name;
    }

    private void validateName(String name){
        if(name.length()>lengthLimit){
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_OVER);
        }
    }
}
