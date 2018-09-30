package laddergame.domain;

public class Player {
    private String name;
    private String result;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public void saveResult(String result) {
        this.result = result;
    }
}
