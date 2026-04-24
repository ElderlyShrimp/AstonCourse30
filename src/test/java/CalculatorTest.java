import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "0, 0, 0",
            "-50, 100, 50",
            "-10, -10, -20",
            "1000, 5000, 6000"
    })
    @DisplayName("Тест сложения двух чисел")
    void sumTest(int inputOne, int inputTwo, int expected){
        int result = Calculator.sum(inputOne, inputTwo);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "5, 0, 5",
            "0, 5, -5",
            "10, 5, 5",
            "5, 10, -5",
            "-10, 5, -15",
            "10000, 5000, 5000"
    })
    @DisplayName("Тест вычитания одного числа из другого")
    void subtractionTest(int inputOne, int inputTwo, int expected){
        int result = Calculator.subtraction(inputOne, inputTwo);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 5, 0",
            "10, 2, 5",
            "10, 3, 3",
            "-10, 2, -5",
            "-10, -2, 5",
            "10, -2, -5",
            "5, 10, 0"
    })
    @DisplayName("Тест деления одного корректного числа на другое")
    void splitTest(int inputOne, int inputTwo, int expected){
        int result = Calculator.split(inputOne, inputTwo);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 0",
            "-10, 0",
            "0, 0"
    })
    @DisplayName("Тест деления числа на ноль")
    void negativeSplitTest(int inputOne, int inputTwo){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.split(inputOne, inputTwo);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "0, 5, 0",
            "5, 0, 0",
            "2, 3, 6",
            "-2, 3, -6",
            "-2, -3, 6",
            "10, -4, -40"
    })
    @DisplayName("Тест произведения двух чисел")
    void multiplicationTest(int inputOne, int inputTwo, int expected){
        int result = Calculator.multiplication(inputOne, inputTwo);
        assertEquals(expected, result);
    }
}
