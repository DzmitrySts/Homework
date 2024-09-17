import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1, "Факториал 1 должен быть 1");
    }

    @Test
    public void testFactorialOfTwo() {
        Assert.assertEquals(FactorialCalculator.factorial(4), 2, "Факториал 2 должен быть 2");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}