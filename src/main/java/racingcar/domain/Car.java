package racingcar.domain;

import static racingcar.global.util.Validator.validateNameLength;
import static racingcar.global.util.Validator.validateNameNumber;



public class Car {
    private final String name;
    private final Position position;
    private final int lengthLimit = 5;

    public Car(String name) {
        validateNameLength(name,lengthLimit);
        validateNameNumber(name);
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
}