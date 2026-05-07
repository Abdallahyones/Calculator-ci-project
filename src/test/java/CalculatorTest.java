import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide_int(6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide_int(5, 0));
    }

    // ===== Edge Cases =====

    @Test
    void testAddWithZero() {
        assertEquals(7, calc.add(7, 0));
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0, calc.multiply(100, 0));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-1, calc.add(-2, 1));
        assertEquals(-3, calc.subtract(-1, 2));
    }

    // ===== Overflow related tests =====

    @Test
    void testAddOverflow() {
        int result = calc.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result); // Java overflow behavior
    }

    @Test
    void testMultiplyOverflow() {
        int result = calc.multiply(Integer.MAX_VALUE, 2);
        assertTrue(result < 0); // overflow leads to negative value
    }
}