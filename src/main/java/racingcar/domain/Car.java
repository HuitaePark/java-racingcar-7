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
        if(isMoveable(pickRandomNum())){
            position.increaseValue();
        }
    }

    private int pickRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    private boolean isMoveable(int randomCount){
        return randomCount >= 4;
    }

    public int getTraveled() {
        return position.getValue();
    }

    public String getName() {
        return name;
    }

}
