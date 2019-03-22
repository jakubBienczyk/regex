package pl.jakub.regex.tests;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeTest {

    private Palindrome palindrome = new Palindrome();

    @Test
    public void testBigPalindrome() {
        String input = createPalindrome();
        boolean result = this.palindrome.isPalindrome(input);
        assertThat(result)
            .isTrue();
    }

    private String createPalindrome() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append(i % 10);
        }

        for (int i = 9999; i >= 0; i--) {
            builder.append(i % 10);
        }
        return builder.toString();
    }

}