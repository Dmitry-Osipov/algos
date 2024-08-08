package osipov.dmitry.math;

public class FindFactorial {
    public static void main(String[] args) {
        System.out.println(Math.round(factorialByStirling(0)));  // 0
        System.out.println(Math.round(factorialByStirling(1)));  // 1
        System.out.println(Math.round(factorialByStirling(2)));  // 2
        System.out.println(Math.round(factorialByStirling(3)));  // 6
        System.out.println(Math.round(factorialByStirling(4)));  // 24
        System.out.println(Math.round(factorialByStirling(5)));  // 118
        System.out.println(Math.round(factorialByStirling(6)));  // 710
        System.out.println(Math.round(factorialByStirling(7)));  // 4980

        System.out.println("------------------------------------");

        System.out.println(factorial(0));  // 0
        System.out.println(factorial(1));  // 1
        System.out.println(factorial(2));  // 2
        System.out.println(factorial(3));  // 6
        System.out.println(factorial(4));  // 24
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(6));  // 720
        System.out.println(factorial(7));  // 5040
    }

    public static double factorialByStirling(int n) {
        var firstOperand = Math.sqrt(2 * n * Math.PI);
        var secondOperand = Math.pow(n / Math.E, n);
        return firstOperand * secondOperand;
    }

    public static long factorial(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
