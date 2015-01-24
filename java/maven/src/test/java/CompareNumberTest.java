import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhouyong on 1/24/15.
 */
public class CompareNumberTest {
    @Test
    public void should_be_return_4A0B_when_given_input_is_1234_and_answer_is_1234() {
        //given
        String input = "1234";
        String answer = "1234";

        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input, answer);
        assertThat(result).isEqualTo("4A0B");
    }

    @Test
    public void should_be_return_0A0B_when_given_input_is_1234_and_answer_is_5678() {
        //given
        String input = "1234";
        String answer = "5678";

        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input, answer);

        assertThat(result).isEqualTo("0A0B");
    }
}
