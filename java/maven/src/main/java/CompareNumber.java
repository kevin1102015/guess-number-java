/**
 * Created by zhouyong on 1/24/15.
 */
public class CompareNumber {
    public String getTips(String input, String answer) {
        int aCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                aCount++;
            }
        }
        if (aCount == 4) {
            return "4A0B";
        }

        int containsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                containsCount++;
            }
        }
        if (containsCount == 0) {
            return "0A0B";
        }

        return null;
    }
}
