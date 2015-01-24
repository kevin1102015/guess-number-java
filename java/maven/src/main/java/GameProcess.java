import java.io.PrintStream;

/**
 * Created by zhouyong on 1/24/15.
 */
public class GameProcess {
    private PrintStream out;

    public GameProcess(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("Welcome!");
    }
}
