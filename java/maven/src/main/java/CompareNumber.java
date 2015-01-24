/**
 * Created by zhouyong on 1/24/15.
 */
public class CompareNumber {
    public String getTips(String input, String answer) {
        if (input.equals(answer)) {
            return "4A0B";
        }

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                count++;
            }
        }

        if (count == 0) {
            return "0A4B";
        }

        return null;
    }
}
