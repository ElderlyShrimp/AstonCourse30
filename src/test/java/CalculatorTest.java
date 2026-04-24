import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {
    @DataProvider(name = "sumTest")
    public Object[][] sumTest(){
        return new Object[][]{
                {1, 1, 2},
                {0, 0, 0},
                {-50, 100, 50},
                {-10, -10, -20},
                {1000, 5000, 6000},
                {5, -3, 2},
                {-7, 3, -4}
        };
    }

    @Test(dataProvider = "sumTest")
    public void testSum(int inputOne, int inputTwo, int expected){
        int result = Calculator.sum(inputOne, inputTwo);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "subtractionTest")
    public Object[][] subtractionTest() {
        return new Object[][] {
                {0, 0, 0},
                {5, 0, 5},
                {0, 5, -5},
                {10, 5, 5},
                {5, 10, -5},
                {-10, 5, -15},
                {10000, 5000, 5000}
        };
    }

    @Test(dataProvider = "subtractionTest")
    public void testSubtraction(int a, int b, int expected) {
        int result = Calculator.subtraction(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "multiplicationTest")
    public Object[][] multiplicationTest() {
        return new Object[][] {
                {0, 0, 0},
                {0, 5, 0},
                {5, 0, 0},
                {2, 3, 6},
                {-2, 3, -6},
                {-2, -3, 6},
                {10, -4, -40},
                {100, 50, 5000}
        };
    }

    @Test(dataProvider = "multiplicationTest")
    public void testMultiplication(int a, int b, int expected) {
        int result = Calculator.multiplication(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "divisionTest")
    public Object[][] divisionTest() {
        return new Object[][] {
                {0, 5, 0},
                {10, 2, 5},
                {10, 3, 3},
                {-10, 2, -5},
                {-10, -2, 5},
                {10, -2, -5},
                {5, 10, 0}
        };
    }

    @Test(dataProvider = "divisionTest")
    public void testDivision(int a, int b, int expected) {
        int result = Calculator.split(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "divisionByZeroTest")
    public Object[][] divisionByZeroTest() {
        return new Object[][] {
                {10, 0},
                {-10, 0},
                {0, 0}
        };
    }

    @Test(dataProvider = "divisionByZeroTest")
    public void testDivisionByZero(int a, int b) {
        Assert.expectThrows(ArithmeticException.class, () -> {
            Calculator.split(a, b);
        });
    }
}
