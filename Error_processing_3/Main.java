package Error_processing_3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {
    private static final int exp = 6;

    public static void main(String[] args) throws MonthException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите через пробел: Фамилия Имя Отчество датарождения номертелефона пол: ");
        String[] input = scanner.nextLine().split("\\s+");

        if (input.length != exp) {
            System.err.println("Надо ввести " + exp + "данных, вы ввели " + input.length);
            return;
        }

        String surname = input[0];
        String firstName = input[1];
        String patronymic = input[2];
        String date = input[3];
        String phoneNumber = input[4];
        String gender = input[5];

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(date, dateFormatter);

            int month = dateOfBirth.getMonthValue();
            if (month == 2) {
                int day = dateOfBirth.getDayOfMonth();
                if (day > 29) {
                    throw new MonthException("В феврале не может быть больше 29 дней.");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                int day = dateOfBirth.getDayOfMonth();
                if (day > 30) {
                    throw new MonthException("В этом месяце не может быть больше 30 дней");
                }
            }

            LocalDate now = LocalDate.now();
            if (dateOfBirth.isAfter(now)) {
                throw new RuntimeException("Неверная дата рождения: дата не может быть в будущем");
            }
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Неверная дата рождения: " + ex.getMessage(), ex);
        }

        try {
            if (gender.length() != 1) {
                throw new Exception("Ошибка! Неверный ввод.Введите один символ для пола");
            }

            char gen = gender.charAt(0);

            if (gen != 'm' && gen != 'f') {
                throw new Exception("Ошибка! Неверный ввод пола. Введите f или m");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            if (surname.matches(".*\\d.*") || firstName.matches(".*\\d.*") || patronymic.matches(".*\\d.*")) {
                throw new Exception("Ошибка! В ФИО не должно быть чисел");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        int phone;
        try {
            phone = Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            System.out.println("Ошибк! номер телефона содержит нечисловые символы.");
            return;
        }

        // Здесь мы записываем файл
        // Я работал с UFT-8 но у меня киррилица записываетя не правильно
        // Напишите как исправить это
        Person person = new Person(surname, firstName, patronymic, dateOfBirth, phoneNumber, gender);
        String filename = surname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename, true), "UTF-8"))) {
            writer.write(person.toString());
            writer.close();
            System.out.println("Данные успешно записаны " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + filename);
            e.printStackTrace();
        }

    }
}
