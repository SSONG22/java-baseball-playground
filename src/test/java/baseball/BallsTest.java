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

}