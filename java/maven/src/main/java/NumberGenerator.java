import java.util.Random;

/**
 * Created by zhouyong on 1/24/15.
 */
public class NumberGenerator {
    public String genetate() {
        Random random = new Random();
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
