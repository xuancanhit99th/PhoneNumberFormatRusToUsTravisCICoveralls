package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testFormatPhoneNumber() {
        String input = "+1 (123) 456-78-90";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithDifferentInput() {
        String input = "+7 123 456-78-90";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithNoSpaces() {
        String input = "+71234567890";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }
}
