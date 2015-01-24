import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by zhouyong on 1/24/15.
 */
public class GameProcessTest {
    @Test
    public void should_print_welcome() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        verify(out, never()).println("Welcome!");

        game.start();

        verify(out).println("Welcome!");
    }

    @Test
    public void should_print_please_input_you_answer_when_game_started() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
    }
}
