public class FactorialCalculator {

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Для отрицательных чисел нельзя вычислить факториал");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}