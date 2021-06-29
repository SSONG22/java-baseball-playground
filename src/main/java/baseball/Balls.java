package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> computer;

    public Balls(List<Integer> numbers) {
        this.computer = mapBall(numbers);
    }

    public static List<Ball> mapBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball user) {
        return computer.stream()
                .map(answer -> answer.play(user))
                .filter(BallStatus::isNotNoting) // 직접 접근하던 것을 메세지를 보낸다.
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
