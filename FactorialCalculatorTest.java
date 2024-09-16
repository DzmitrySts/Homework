import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(0, FactorialCalculator.factorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    public void testFactorialOfTwo() {
        assertEquals(2, FactorialCalculator.factorial(2), "Факториал 2 должен быть 2");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
        assertEquals(1, exception.getMessage());
    }

}