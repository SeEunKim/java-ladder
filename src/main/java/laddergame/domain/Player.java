package laddergame.domain;

import static laddergame.util.Util.MOVE_LEFT;
import static laddergame.util.Util.MOVE_RIGHT;

public class Player {
    private String name;
    private int index;

    public Player(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    private void moveRight(boolean isTrue) {
        if (isTrue == true) {
            this.index += MOVE_RIGHT;
        }
    }

    private void moveLeft(boolean isTrue) {
        if (isTrue == true) {
            this.index += MOVE_LEFT;
        }
    }

    public void move(boolean isLeft, boolean isRight) {
        moveLeft(isLeft);
        moveRight(isRight);
    }
}
