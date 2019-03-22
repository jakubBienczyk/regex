package pl.jakub.regex.tests;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatesTest {

    private Dates dates = new Dates();

    @Test
    public void test1() {
        String date = "12-11-2009";
        int month = dates.getMonth(date);
        assertThat(month)
            .isEqualTo(11);
    }

    @Test
    public void test2() {
        String date = "1-1-2009";
        int month = dates.getMonth(date);
        assertThat(month)
            .isEqualTo(1);
    }

    @Test
    public void test3() {
        String date = "12-01-2009";
        int month = dates.getMonth(date);
        assertThat(month)
            .isEqualTo(1);
    }

    @Test
    public void test4() {
        String date = "2.11.2009";
        int month = dates.getMonth(date);
        assertThat(month)
            .isEqualTo(11);
    }

    @Test
    public void test5() {
        String date = "12.01.1119";
        int month = dates.getMonth(date);
        assertThat(month)
            .isEqualTo(1);
    }

}