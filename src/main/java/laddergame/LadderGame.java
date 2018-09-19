package laddergame;

import java.util.ArrayList;

public class LadderGame {
    ArrayList<Ladder> ladders = new ArrayList<>();

    public ArrayList<Ladder> getLadders() {
        return this.ladders;
    }

    public void playGame(int people, int maxHeight) {
        for(int i=0; i<people-1; i++) {
            Ladder ladder = new Ladder(maxHeight);
            ladder.makeLine(maxHeight);
            ladders.add(ladder);
        }
    }
}
