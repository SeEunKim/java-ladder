package laddergame.domain;

import laddergame.util.Util;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        makeLine(countOfPerson);
    }

    public ArrayList<Boolean> getLines() {
        return this.points;
    }

    public void makeLine(int countOfPerson) {
        boolean preResult = false;

        for (int pos = 0; pos < countOfPerson - 1; pos++) {
            preResult = isMakeLine(preResult);
            points.add(preResult);
        }
    }

    public static boolean isMakeLine(boolean preResult) {
        boolean result = false;
        int randomNumber = Util.generateRandomNumber();

        if (((randomNumber % 3) != 0) && (preResult != true)) {
            result = true;
        }
        return result;
    }

    public void move(Player player) {
        int index = player.getIndex();

        if (index == 0) {
            player.move(false, points.get(index));
        }

        if (index == points.size()) {
            player.move(points.get(index - 1), false);
        }

        if (index > 0 && index < points.size()) {
            player.move(points.get(index-1), points.get(index));
        }
    }
}
