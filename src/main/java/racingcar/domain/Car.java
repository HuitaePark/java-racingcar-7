package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int traveled = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        if(isMoveable(pickRandomNum())){
            traveled++;
        }
    }

    private int pickRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    private boolean isMoveable(int randomCount){
        return randomCount >= 4;
    }

    public int getTraveled() {
        return traveled;
    }

    public String getName() {
        return name;
    }


}
