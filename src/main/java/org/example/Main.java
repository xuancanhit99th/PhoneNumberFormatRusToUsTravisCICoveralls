package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/text.txt"; // Укажите путь к файлу с текстом
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Регулярное выражение для поиска телефонных номеров
        String regex = "\\+?\\d{1,4}?[\\s-]?\\(?(\\d{3})\\)?[\\s-]?(\\d{3})[\\s-]?(\\d{2})[\\s-]?(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            // Найденный номер телефона
            String phone = matcher.group();
            // Заменяем номер телефона на форматированный
            matcher.appendReplacement(result, formatPhoneNumber(phone));
        }
        matcher.appendTail(result);

        System.out.println(result.toString());
    }

    public static String formatPhoneNumber(String phone) {
        // Удаляем все кроме цифр
        String digits = phone.replaceAll("\\D", "");
        if (digits.length() == 10) {
            // Если длина цифр равна 10, предполагаем код страны +1
            return "+1 (" + digits.substring(0, 3) + ") " + digits.substring(3, 6) + "-" + digits.substring(6, 8) + "-" + digits.substring(8);
        } else if (digits.length() > 10) {
            // Если длина цифр больше 10, предполагаем наличие кода страны
            String countryCode = digits.substring(0, digits.length() - 10);
            String areaCode = digits.substring(digits.length() - 10, digits.length() - 7);
            String localNumber = digits.substring(digits.length() - 7);
            return "+" + countryCode + " (" + areaCode + ") " + localNumber.substring(0, 3) + "-" + localNumber.substring(3, 5) + "-" + localNumber.substring(5);
        } else {
            return "Invalid number";
        }
    }
}
