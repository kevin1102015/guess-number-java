import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by zhouyong on 1/24/15.
 */
public class GameProcessTest {
    private PrintStream out;
    private GameProcess game;
    private BufferedReader reader;
    private NumberGenerator numberGenerator;
    private InOrder inOrder;

    @Before
    public void set_up() throws IOException {
        out = mock(PrintStream.class);

        reader = mock(BufferedReader.class);
        numberGenerator = mock(NumberGenerator.class);
        CompareNumber compareNumber = new CompareNumber();

        game = new GameProcess(out,reader,numberGenerator,compareNumber);
        given(reader.readLine()).willReturn("1234");
        given(numberGenerator.generate()).willReturn("4321");
        inOrder = inOrder(out);
    }

    @Test
    public void should_print_welcome() throws IOException {
        verify(out, never()).println("Welcome!");

        game.start();

        verify(out).println("Welcome!");
    }

    @Test
    public void should_print_please_input_you_answer_when_game_started() throws IOException {
        game.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
    }

    @Test
    public void should_reduce_one_chance_when_guess_wrong() throws IOException {
        game.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(5): ");
    }

    @Test
    public void should_reduce_chance_one_by_one_until_game_over() throws IOException {
        game.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(5): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(4): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(3): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(2): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(1): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Game over!");

    }
    
    @Test
    public void should_congratulate_when_input_is_right() throws IOException {
        given(numberGenerator.generate()).willReturn("1234");

        game.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6): ");
        inOrder.verify(out).println("Congratulate, you win!");
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out,never()).println("Game over!");
    }
}
