package laddergame.view;

import laddergame.domain.LadderGame;
import laddergame.domain.Line;
import laddergame.domain.Player;

import java.util.ArrayList;

public class ResultView {
    private static final String VERTICAL_BAR = "|";
    private static final String HYPHEN = "-----";
    private static final String EMPTY_SPACE = "     ";

    public static void printLadderGameResult(LadderGame ladderGame) {
        ArrayList<Line> lines;
        lines = ladderGame.getLines();

        System.out.println("\n사다리 결과\n");
        printPlayerName(ladderGame.getPlayers());
        for (int i = 0; i < lines.size(); i++) {
            printLine(lines.get(i).getLines());
        }
        printResults(ladderGame.getResults());
    }

    private static void printResults(String[] results) {
        for (String result : results) {
            System.out.print(String.format("%-6s", result));
        }
        System.out.println();
    }

    public static void printPlayerName(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.print(String.format("%-6s", player.getName()));
        }
        System.out.println();
    }

    public static void printLine(ArrayList<Boolean> line) {
        for (int i = 0; i < line.size(); i++) {
            System.out.print(VERTICAL_BAR);
            System.out.print(printHyphen(line.get(i)));
        }
        System.out.println(VERTICAL_BAR);
    }

    public static String printHyphen(boolean isLine) {
        String line = EMPTY_SPACE;
        if (isLine == true) {
            line = HYPHEN;
        }
        return line;
    }

    public static boolean printResultForName(LadderGame lg, String name) {
        ArrayList<Player> players = new ArrayList<>();
        players = lg.getPlayers();
        boolean isFinish = false;

        if(name.equals("ALL") || name.equals("all")) {
            isFinish = printResultForNameAll(players, isFinish);
        }
        printResultForEachName(name, players);

        return isFinish;
    }

    private static void printResultForEachName(String name, ArrayList<Player> players) {
        for (Player player : players) {
            isInputName(name, player);
        }
    }

    private static void isInputName(String name, Player player) {
        if(name.equals(player.getName())) {
            System.out.println(player.getName() + " : " + player.getResult());
        }
    }

    private static boolean printResultForNameAll(ArrayList<Player> players, boolean isFinish) {
        for (Player player : players) {
            System.out.println(player.getName() + " : " + player.getResult());
            isFinish = true;
        }
        return isFinish;
    }
}
