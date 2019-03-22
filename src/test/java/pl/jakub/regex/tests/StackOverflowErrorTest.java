package pl.jakub.regex.tests;

import java.util.regex.Pattern;
import org.junit.Test;

public class StackOverflowErrorTest {

    @Test
    public void test() {
        String data = "";
        for (int i = 0; i < 1400; i++) {
            data = data.concat(Integer.toHexString(1));
        }
        Pattern.compile("^([a-fA-F]|\\d)+$").matcher(data).matches();
    }

}
