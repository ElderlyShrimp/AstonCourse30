import org.example.AreaTriangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTriangleTest {
    @ParameterizedTest
    @CsvSource({
            "10, 5, 25.0",
            "3, 4, 6.0",
            "7, 3, 10.5",
            "2.5, 4, 5.0",
            "5, 2.5, 6.25",
            "1, 1, 0.5",
            "100, 50, 2500.0",
            "0, 5, 0.0",
            "5, 0, 0.0"
    })
    void areaTest(double inputOne, double inputTwo, double expected){
        double result = AreaTriangle.area(inputOne, inputTwo);
        assertEquals(expected, result, 0.001);
    }
}
