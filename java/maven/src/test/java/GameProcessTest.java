import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
}
