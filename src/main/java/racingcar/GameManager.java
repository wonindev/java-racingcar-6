package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    public static void GameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        ExceptionHandler eh = new ExceptionHandler();
        eh.isCarNamePlainTextException(input);

        List<String> members = Arrays.asList(input.split(","));
        eh.isMembersException(members);

        HashMap<String, String> membersHM = new HashMap<>();
        CarMovement.putHM(membersHM, members, "");

        System.out.println("시도할 회수는 몇회인가요?");
        String attempt = readLine();
        eh.isAttemptException(attempt);
        int attemptNum = Integer.parseInt(attempt);

        Print.progress(attemptNum, members, membersHM);

        Print.winner(whoIsWinner(membersHM, members));
    }

    public static List<String> whoIsWinner(HashMap<String, String> membersHM, List<String> members) {
        int max = Integer.MIN_VALUE;
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {
            int len = membersHM.get(members.get(i)).length();
            if (len > max) {
                max = len;
                winner.clear();
                winner.add(members.get(i));
            } else if (len == max) {
                winner.add(members.get(i));
            }
        }

        return winner;
    }
}
