/**
 * Created by zhouyong on 1/24/15.
 */
public class CompareNumber {
    public String getTips(String input, String answer) {
        int aCount = 0, containsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                containsCount++;
            }
            if (input.charAt(i) == answer.charAt(i)) {
                aCount++;
            }
        }
        return aCount + "A" + (containsCount - aCount) + "B";
    }

}
