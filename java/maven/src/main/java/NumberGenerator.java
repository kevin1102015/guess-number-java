import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhouyong on 1/24/15.
 */
public class NumberGenerator {
    private final ArrayList<String> historyGenerateDigits;
    private Random random;

    public NumberGenerator(Random random) {
        this.random = random;
        this.historyGenerateDigits = new ArrayList<String>();
    }

    public String generate() {
        String number = generateOnce();
        while (historyGenerateDigits.contains(number)) {
            number = generateOnce();
        }
        historyGenerateDigits.add(number);
        return number;
    }

    private String generateOnce() {
        StringBuilder number = new StringBuilder();
        while (number.length() < 4) {
            String digit = String.valueOf(random.nextInt(10));
            if (number.indexOf(digit) == -1) {
                number.append(digit);
            }
        }
        return number.toString();
    }
}
