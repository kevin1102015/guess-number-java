import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by zhouyong on 1/24/15.
 */
public class NumberGeneratorTest {
    @Test
    public void should_generate_4_digits_string(){
        String number = new NumberGenerator().genetate();
        assertThat(number.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_number(){
        String number = new NumberGenerator().genetate();
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            fail("result should be number.");
        }
    }
    
    @Test
    public void should_generate_no_duplicate_digits_string(){
        String number = new NumberGenerator().genetate();
        for (int i = 0; i < number.length(); i++) {
            assertThat(number.indexOf(number.charAt(i))).isEqualTo(number.lastIndexOf(number.charAt(i)));
        }
    }
}
