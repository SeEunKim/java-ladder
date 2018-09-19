package laddergame;

import java.util.ArrayList;

public class ResultView {
    private static final String verticalBar = "|";

    public static void printResult(LadderGame ladderGame, int maxHeight) {
        ArrayList<Ladder> ladders;
        ladders = ladderGame.getLadders();

        for(int i=0; i<maxHeight; i++) {
            System.out.print(verticalBar);
            printLines(ladders, i);
            System.out.println();
        }
    }

    public static void printLines(ArrayList<Ladder> ladders, int i) {
        for(int j=0; j<ladders.size(); j++) {
            String lines[] = ladders.get(j).getLines();
            System.out.print(lines[i]);
            System.out.print(verticalBar);
        }
    }
}
