package bowling;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingTest {

    private Bowling bowling;

    @Before
    public void setUp(){
        bowling = new Bowling();
    }

    @Test
    public void shouldReturn0WhenRollsAreBothZero() {

        assertThat(bowling.getScore()).isEqualTo(0);
    }

    @Test
    public void shouldReturn1When1IsScored() {
        int[][] scores = {{1}};

        bowling.gameScores(scores);

        assertThat(bowling.getScore()).isEqualTo(1);
    }

    @Test
    public void shouldReturn3When2And1ArePassedIn() {
        int[][] scores = {{2, 1}};

        bowling.gameScores(scores);

        assertThat(bowling.getScore()).isEqualTo(3);
    }

    @Test
    public void shouldReturn10When1234PassedIn() {
        int[][] scores = {{1, 2}, {3, 4}};

        bowling.gameScores(scores);

        assertThat(bowling.getScore()).isEqualTo(10);
    }

    @Test
    public void shouldDoubleNextTurnWhenStrike() {
        int[][] scores = {{10}, {2, 1}};

        bowling.gameScores(scores);

        assertThat(bowling.getScore()).isEqualTo(16);
    }
}
