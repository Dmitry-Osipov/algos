package osipov.dmitry.math;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

        System.out.println("-----------------------------------------------");

        for (int i = 1; i <= 100; i++) {
            if (isPrimeOptimized(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrimeOptimized(int number) {
        if (number < 2) {
            return false;
        }

        if (number % 2 == 0) {
            return number == 2;
        }

        if (number % 3 == 0) {
            return number == 3;
        }

        for (int i = 5; i * i <= number; i += 6) {  // Пропускаем составные числа
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(long number) {
        return isPrime(number, 2);
    }

    private static boolean isPrime(long number, long divisor) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % divisor == 0) {
            return false;
        }

        if (divisor * divisor > number) {
            return true;
        }

        return isPrime(number, divisor+1);
    }
}
