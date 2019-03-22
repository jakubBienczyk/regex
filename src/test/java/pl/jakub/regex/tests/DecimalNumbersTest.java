package pl.jakub.regex.tests;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DecimalNumbersTest {

    private DecimalNumbers decimalNumbers = new DecimalNumbers();

    @Test
    public void zeroIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers.isDecimalNumber("0");
        assertThat(isDecimalNumber)
            .as("zero is a decimal number")
            .isTrue();
    }

    @Test
    public void fiveIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers.isDecimalNumber("5");
        assertThat(isDecimalNumber)
            .as("five is a decimal number")
            .isTrue();
    }

    @Test
    public void minusSixIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers.isDecimalNumber("-6");
        assertThat(isDecimalNumber)
            .as("-6 is a decimal number")
            .isTrue();
    }

    @Test
    public void almostPiIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("3.141592653589793238462643383279502884197169399375105820974944592307816406208998");
        assertThat(isDecimalNumber)
            .as("aprox of PI is a decimal number")
            .isTrue();
    }

    @Test
    public void minusAproxOfEIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("-2.7182818284590452353602874713527");
        assertThat(isDecimalNumber)
            .as("minus aprox of e is a decimal number")
            .isTrue();
    }

    @Test
    public void thisHugeNumberIsDecimalNumber() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("7182818284590452353602874713527.264338327950288419716939937");
        assertThat(isDecimalNumber)
            .as("7182818284590452353602874713527.264338327950288419716939937 is a decimal number")
            .isTrue();
    }

    @Test
    public void zeroAsStringIsNotDecimal() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("zero");
        assertThat(isDecimalNumber)
            .as("'zero' is not a decimal number")
            .isFalse();
    }

    @Test
    public void cannotReplaceOneWithL() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("11111111l11111111");
        assertThat(isDecimalNumber)
            .as("'11111111l11111111' is not a decimal number")
            .isFalse();
    }

    @Test
    public void cannotReplaceZerosWitkK() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("123k");
        assertThat(isDecimalNumber)
            .as("'123k' is not a decimal number")
            .isFalse();
    }

    @Test
    public void cannotReplaceTheDot() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("123,000");
        assertThat(isDecimalNumber)
            .as("'123,000' is not a decimal number")
            .isFalse();
    }

    @Test
    public void thereShouldBeSomethingAfterTheDot() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("1.");
        assertThat(isDecimalNumber)
            .as("there should be something after the dot")
            .isFalse();
    }

    @Test
    public void thereShouldBeSomethingBeforeTheDot() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber(".1");
        assertThat(isDecimalNumber)
            .as("there should be something before the dot")
            .isFalse();
    }

    @Test
    public void dotDoesNotChangeAnything() {
        boolean isDecimalNumber = decimalNumbers
            .isDecimalNumber("123.123k");
        assertThat(isDecimalNumber)
            .as("'123.123k' is not a decimal number")
            .isFalse();
    }

    @Test
    public void zeroHasZeroAsDecimalFraction() {
        int decimalFraction = decimalNumbers.getDecimalFraction("0");
        assertThat(decimalFraction)
            .as("zero has zero")
            .isEqualTo(0);
    }

    @Test
    public void piHasOneAsDecimalFraction() {
        int decimalFraction = decimalNumbers.getDecimalFraction("3.1415");
        assertThat(decimalFraction)
            .as("pi has one as decimal fraction")
            .isEqualTo(1);
    }

    @Test
    public void minusPiHasOneAsDecimalFraction() {
        int decimalFraction = decimalNumbers.getDecimalFraction("-3.1415");
        assertThat(decimalFraction)
            .as("pi has one as decimal fraction")
            .isEqualTo(1);
    }

}