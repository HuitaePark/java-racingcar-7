package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
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
