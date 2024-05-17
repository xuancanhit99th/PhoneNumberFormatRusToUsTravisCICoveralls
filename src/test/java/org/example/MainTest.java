package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String expected = "+7 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithNoSpaces() {
        String input = "+71234567890";
        String expected = "+7 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithDashes() {
        String input = "+1-123-456-78-90";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithBrackets() {
        String input = "+1 (123) 456-78-90";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithSpaces() {
        String input = "+1 123 456 78 90";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithCountryCode() {
        String input = "+44 123 456 78 90";
        String expected = "+44 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithShortNumber() {
        String input = "1234567890";
        String expected = "+1 (123) 456-78-90";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPhoneNumberWithInvalidNumber() {
        String input = "123";
        String expected = "Invalid number";
        String actual = Main.formatPhoneNumber(input);
        assertEquals(expected, actual);
    }

//    @Test
//    public void testMainWithValidFile() throws IOException {
//        // Create a temporary file with test content
//        String testContent = "+1 (123) 456-78-90\n+7 123 456-78-90\n+44 123 456 78 90";
//        Files.write(Paths.get("src/main/java/org/example/test.txt"), testContent.getBytes());
//
//        // Redirect standard output to capture the output of the main method
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        // Run the main method
//        Main.main(new String[]{});
//
//        // Check the output
//        String expectedOutput = "+1 (123) 456-78-90\n+7 (123) 456-78-90\n+44 (123) 456-78-90\n";
//        assertEquals(expectedOutput, outContent.toString());
//
//        // Clean up the temporary file
//        Files.delete(Paths.get("src/main/java/org/example/test.txt"));
//    }

//    @Test
//    public void testMainWithEmptyFile() throws IOException {
//        // Create a temporary empty file
//        Files.createFile(Paths.get("src/main/java/org/example/test.txt"));
//
//        // Redirect standard output to capture the output of the main method
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        // Run the main method
//        Main.main(new String[]{});
//
//        // Check the output
//        String expectedOutput = "";
//        assertEquals(expectedOutput, outContent.toString());
//
//        // Clean up the temporary file
//        Files.delete(Paths.get("src/main/java/org/example/test.txt"));
//    }

//    @Test
//    public void testMainWithNonExistentFile() {
//        // Redirect standard error to capture the error output of the main method
//        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//        System.setErr(new PrintStream(errContent));
//
//        // Run the main method with a non-existent file path
//        Main.main(new String[]{"non_existent_file.txt"});
//
//        // Check the error output
//        assertTrue(errContent.toString().contains("Error reading the file"));
//    }
}
