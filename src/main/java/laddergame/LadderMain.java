package laddergame;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.getName();
        int maxHeight = InputView.getMaxHeight();

        LadderGame ladderGame = new LadderGame();
        ladderGame.playGame(names, maxHeight);

        ResultView.printResult(ladderGame);
    }
}