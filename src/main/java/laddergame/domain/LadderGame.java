package laddergame.domain;

import laddergame.util.Util;

import java.util.ArrayList;

public class LadderGame {
    private ArrayList<Player> players = new ArrayList<>();
    private String[] results;

    private ArrayList<Line> lines = new ArrayList<>();

    public LadderGame(String names, String result) {
        String[] name = names.split(Util.COMMA);
        for (int i = 0; i < name.length; i++) {
            players.add(new Player(name[i]));
        }
        results = result.split(Util.COMMA);
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void makeLadder(int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            Line line = new Line(players.size());
            lines.add(line);
        }
    }

    public void playGame() {
        for (int i = 0; i < players.size(); i++) {
            getGameResult(i);
        }
    }

    public void getGameResult(int location) {
        int index = location;

        for (int i = 0; i < lines.size(); i++) {
            index = getIndexLine(index, i);
            players.get(location).saveResult(results[index]);
        }
    }

    private int getIndexLine(int index, int i) {
        if(index == 0) {
            index = getIndexFirst(index, i);
        } else if(index == lines.get(0).getLines().size()) {
            index = getIndexLast(index, i);
        } else {
            index = getIndex(index, i);
        }
        return index;
    }

    private int getIndex(int index, int i) {
        if(lines.get(i).getLines().get(index) == true) {
            index = index + 1;
        } else if(lines.get(i).getLines().get(index - 1) == true) {
            index = index - 1;
        }
        return index;
    }

    private int getIndexLast(int index, int i) {
        if(lines.get(i).getLines().get(index - 1) == true) {
            index = index - 1;
        }
        return index;
    }

    private int getIndexFirst(int index, int i) {
        if(lines.get(i).getLines().get(index) == true) {
            index = index + 1;
        }
        return index;
    }

    public String[] getResults() {
        return results;
    }
}
