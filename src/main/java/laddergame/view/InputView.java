package laddergame.view;

import laddergame.util.Util;

import java.util.Scanner;

public class InputView {
    public static final int MAX_NAME_LENGTH = 5;
    public static Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        String names = null;
        boolean isPass = false;

        while (isPass == false) {
            System.out.println("참여할 사람 이름을 입력하세요. 최대5글자.(이름은 쉼표(,)로 구분하세요)");
            names = scanner.next();
            isPass = checkName(names);
        }
        return names;
    }

    public static boolean checkName(String input) {
        boolean result = true;

        String[] names = input.split(Util.COMMA);
        for (String name : names) {
            result = checkNameLength(result, name);
        }
        return result;
    }

    public static boolean checkNameLength(boolean result, String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            result = false;
        }
        return result;
    }

    public static int getMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

    public static String getResult(int playerNum) {
        boolean isPass = false;
        String result = null;

        while(isPass == false) {
            System.out.println("참여할 사람과 동일한 숫자의 실행 결과를 입력하세요.(결과는 쉼표(,)로 구분하세요)");
            result = scanner.next();
            isPass = checkResultCount(result, playerNum);
        }
        return result;
    }

    public static boolean checkResultCount(String input, int num) {
        boolean result = true;
        String[] results = input.split(Util.COMMA);

        if(results.length != num) {
            result = false;
        }
        return result;
    }

    public static String getNameForTheResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
