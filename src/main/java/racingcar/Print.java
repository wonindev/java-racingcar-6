package racingcar;

import java.util.HashMap;
import java.util.List;

public class Print {
    public static void progress(int attemptNum, List<String> members, HashMap<String, String> membersHM) {
        System.out.println("실행 결과");

        for (int i = 0; i < attemptNum; i++) {
            CarMovement.putHM(membersHM, members, members.size(), "-");
            for (int j = 0; j < members.size(); j++) {
                System.out.println(members.get(j) + " : " + membersHM.get(members.get(j)));
            }
            System.out.println();
        }
    }

    public static void winner(List<String> winner) {
        String result = String.join(", ", winner);
        System.out.println("최종 우승자 : " + result);
    }
}
