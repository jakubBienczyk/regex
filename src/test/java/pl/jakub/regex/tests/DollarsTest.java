package pl.jakub.regex.tests;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.byLessThan;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DollarsTest {

    private Dollars dollars = new Dollars();

    @Test
    public void test1() {
        String input = "I have 5$ and you have 11.50$";
        List<Double> allDollars = dollars.findAllDollars(input);
        assertThat(allDollars).isNotNull();
        assertThat(allDollars.get(0)).isCloseTo(5, byLessThan(0.01));
        assertThat(allDollars.get(0)).isCloseTo(11.5, byLessThan(0.01));
    }

    @Test
    public void test2() {
        String input = "I have many $$. Like a 100000$ or something$";
        List<Double> allDollars = dollars.findAllDollars(input);
        assertThat(allDollars).isNotNull();
        assertThat(allDollars.get(0)).isCloseTo(100000, byLessThan(0.01));
    }

    @Test
    public void test3() {
        String input = "empty";
        List<Double> allDollars = dollars.findAllDollars(input);
        assertThat(allDollars).isNotNull();
    }

    @Test
    public void test4() {
        String input = "$ is a symbol of money, 2 $ is a symbol of big money";
        List<Double> allDollars = dollars.findAllDollars(input);
        assertThat(allDollars).isNotNull();
    }


}