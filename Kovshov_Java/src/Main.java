import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {

            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\nВыберите режим работы:\n" +
                        "1. Сравнение и арифметические операции с числами\n" +
                        "2. Сравнение строк\n" +
                        "3. Вывод четных чисел из массива\n" +
                        "0. Прекращение работы программы");

                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Введите два целых числа:");
                        var a = scanner.nextBigInteger();
                        var b = scanner.nextBigInteger();
                        compareAndOperate(a, b);
                        scanner.nextLine();
                        break;
                    case "2":
                        System.out.println("Введите две строки:");
                        var str1 = scanner.nextLine();
                        var str2 = scanner.nextLine();
                        compareStrings(str1, str2);
                        break;
                    case "3":
                        printEvenNumbers();
                        break;
                    case "0":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                }
            }

        }
    }

    private static void compareAndOperate(BigInteger a, BigInteger b) {
        int comparisonResult = a.compareTo(b);

        if (comparisonResult > 0) {
            System.out.println("a > b");
        } else if (comparisonResult < 0) {
            System.out.println("a < b");
        } else {
            System.out.println("a = b");
        }

        System.out.println("Сложение: " + a.add(b));
        System.out.println("Вычитание: " + a.subtract(b));
        System.out.println("Умножение: " + a.multiply(b));

        if (!b.equals(BigInteger.ZERO)) {
            var aDecimal = new BigDecimal(a);
            var bDecimal = new BigDecimal(b);
            System.out.println("Деление: " + aDecimal.divide(bDecimal, 10, RoundingMode.FLOOR));
        } else {
            System.out.println("Ошибка: деление на ноль");
        }
    }

    private static void compareStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("Строки идентичны");
        } else {
            System.out.println("Строки неидентичны");
        }
    }

    private static void printEvenNumbers() {
        var array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Числа из массива: " + Arrays.toString(array));
        var result = Arrays.stream(array).filter(value -> value % 2 == 0).toArray();
        System.out.println("Четные числа из массива: " + Arrays.toString(result));
    }
}
