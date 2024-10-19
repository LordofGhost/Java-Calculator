package test.java;
import main.java.Display;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTest {

    @Test
    void checkSymbolString() {
        Display display = new Display();

        for (int i = 0; i < 5; i++) {
            char[] symbols = {'1', '2', '3', '4', '5'};
            display.createBox(symbols[i]);
        }

        assertEquals("12345", display.getSymbolString());
    }
}