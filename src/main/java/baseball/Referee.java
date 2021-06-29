package baseball;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 개수를 구해 뺀다.
        // 남은 수는 볼의 개수다.
        Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);
        int strike = 0;
        for (int placeIndex = 0; placeIndex < computer.size(); placeIndex++) {
            if (judgement.hasPlace(computer, placeIndex, player.get(placeIndex)))
                strike++;
        }
        int ball = correctCount - strike;
        if(strike == 0) return "아웃";
        return ball + " 볼 " + strike + " 스트라이크";
    }
}
