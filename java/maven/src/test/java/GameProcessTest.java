import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by zhouyong on 1/24/15.
 */
public class GameProcessTest {
    private PrintStream out;
    private GameProcess game;

    @Before
    public void set_up() {
        out = mock(PrintStream.class);
        game = new GameProcess(out);
    }

    @Test
    public void should_print_welcome() {
        verify(out, never()).println("Welcome!");

        game.start();

        verify(out).println("Welcome!");
    }

    @Test
    public void should_print_please_input_you_answer_when_game_started() {
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
    }
}
