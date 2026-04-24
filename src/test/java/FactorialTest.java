import org.example.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "19, 121645100408832000"
    })
    @DisplayName("Тест факториала для корректных чисел до 20")
    void multiplicationNumbersTest(int input, long expected){
        long result = Factorial.multiplicationNumbers(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5})
    @DisplayName("Тест факториала для отрицательных чисел")
    void negativeMultiplicationNumbersTest(int input){
        assertThrows(IllegalArgumentException.class, () ->{
            Factorial.multiplicationNumbers(input);
        });
    }

}
