import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by zhouyong on 1/24/15.
 */
public class NumberGeneratorTest {
    @Test
    public void should_generate_4_digits_string(){
        String number = new NumberGenerator(new Random()).generate();
        assertThat(number.length()).isEqualTo(4);
    }
    @Test
    public void should_generate_number(){
        String number = new NumberGenerator(new Random()).generate();
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            fail("result should be number.");
        }
    }
    @Test
    public void should_generate_no_duplicate_digits_string(){
        String number = new NumberGenerator(new Random()).generate();
        for (int i = 0; i < number.length(); i++) {
            assertThat(number.indexOf(number.charAt(i))).isEqualTo(number.lastIndexOf(number.charAt(i)));
        }
    }
    @Test
    public void should_not_repeat_3_times() {
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 4)
                .willReturn(2, 3, 4, 5)
                .willReturn(3, 4, 5, 6);
        NumberGenerator numberGenerator = new NumberGenerator(random);
        HashSet<String> numbers = new HashSet<String>();

        numbers.add(numberGenerator.generate());
        numbers.add(numberGenerator.generate());
        numbers.add(numberGenerator.generate());

        assertThat(numbers.size()).isEqualTo(3);
    }
    @Test
    public void should_be_able_to_repeat_out_of_3_times(){
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 5, 7, 8)
                .willReturn(2, 3, 4, 5)
                .willReturn(1, 2, 3, 4);
        NumberGenerator numberGenerator = new NumberGenerator(random);
        HashSet<String> numbers = new HashSet<String>();

        numbers.add(numberGenerator.generate());
        numbers.add(numberGenerator.generate());
        numbers.add(numberGenerator.generate());
        numbers.add(numberGenerator.generate());

        assertThat(numbers.size()).isEqualTo(3);
    }
}
