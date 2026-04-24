import org.example.ComparingNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparingNumbersTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0, Числа равны",
            "-10, 10, 10 больше -10",
            "50, -50, 50 больше -50",
            "-100, -100, Числа равны",
            "500, 500, Числа равны"
    })
    void compareTest(int inputOne, int inputTwo, String expected){
        String result = ComparingNumbers.compare(inputOne, inputTwo);
        assertEquals(expected, result);
    }
}
