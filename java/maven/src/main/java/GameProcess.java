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
        int count = 6;
        String result = "";
        String input = numberGenerator.generate();
        while (!"4A0B".equals(result)) {
            out.println("Please input your answer(" + count + "): ");
            String answer = reader.readLine();
            result = compareNumber.getTips(input, answer);
            out.println(result);
            count--;
            if (count == 0) {
                out.println("Game over!");
                return;
            }
            if ("4A0B".equals(result)) {
                out.println("Congratulate, you win!");
                return;
            }
        }
    }
}
