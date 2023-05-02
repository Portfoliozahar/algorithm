package Error_processing;

import java.util.InputMismatchException;

import java.util.Scanner;

public class home_work_0002 {

    public static void main(String[] args) {
        // task1(); // ввод дробного числа (типа float)
        // task2(); // найти ошибки
        // task3(); // найти ошибки
        task4(); // пустая строка
    }

    public static float task1() {

        try {

            System.out.println("\nВведите дробное: ");
            Scanner scan = new Scanner(System.in);
            float num = scan.nextFloat();
            System.out.println("Ваш ввод:\n" + (num));
            return num;

        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            task1();
        }
        return 0;
    }

    /**
     * Задача 2
     * добавил массив
     * замена значения d на 1 или исключение с выводом (на 0 делить нельзя)
     */
    public static void task2() {
        try {
            int[] intArray = { 1, 0, 1, 1, 0, 1, 1, 1, 0 };
            int d = 1;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching ArithmeticException: " + e);
        }
    }

    /**
     * Задача 3
     * блок catch IndexOut никогда не будет выполнен, потому что перед ним
     * появляется более общий блок Throwable.
     * надо переместить вниз
     */

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void task4() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        try {
            if (input.trim().isEmpty()) {
                throw new Exception("Пустая строка не может быть введена");
            }
            System.out.println("Ваш ввод: " + input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}