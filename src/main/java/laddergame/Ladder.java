package laddergame;

import java.util.Random;

public class Ladder {
    private final int RANGE = 9;
    private final String DASH = "-";

    private String lines[];

    public Ladder(int maxHeight) {
        this.lines = new String[maxHeight];
    }

    public String[] getLines() {
        return this.lines;
    }

    public void makeLine(int maxHeight) {
        for(int i=0; i<maxHeight; i++) {
            Random random = new Random();
            int r = random.nextInt(RANGE);
            if(r % 2 == 0) {
                this.lines[i] = DASH;
            } else {
                this.lines[i] = " ";
            }
        }
    }
}
