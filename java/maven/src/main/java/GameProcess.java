import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by zhouyong on 1/24/15.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader reader;
    private final NumberGenerator numberGenerator;
    private final CompareNumber compareNumber;

    public GameProcess(PrintStream out, BufferedReader reader, NumberGenerator numberGenerator, CompareNumber compareNumber) {
        this.out = out;
        this.reader = reader;
        this.numberGenerator = numberGenerator;
        this.compareNumber = compareNumber;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        out.println("Please input your answer(6): ");
        String input = numberGenerator.generate();
        String answer = reader.readLine();
        String result = compareNumber.getTips(input, answer);
        out.println(result);
        if (!"4A0B".equals(result)) {
            out.println("Please input your answer(5): ");
        }
    }
}
