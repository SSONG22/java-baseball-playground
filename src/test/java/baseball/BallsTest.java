package baseball;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void nothing(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.play(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.play(new Ball(1,2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }
    @Test
    void strike(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void play_nothing(){
        Balls answer = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answer.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball(){
        Balls answer = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answer.play(Arrays.asList(3,2,6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.isGameEnd()).isFalse();
    }

    @Test
    void play_3strike(){
        Balls answer = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answer.play(Arrays.asList(1,2,3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }
}