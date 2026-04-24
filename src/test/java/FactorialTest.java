import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData(){
        return new Object[][]{
                {0, 1L},
                {1, 1L},
                {5, 120L},
                {19, 121645100408832000L}
        };
    }
    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, long expected){
        long result = Factorial.multiplicationNumbers(input);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "negativeData")
    public Object[][] negativeData() {
        return new Object[][] {
                {-1},
                {-5},
                {-10}
        };
    }
    @Test(dataProvider = "negativeData")
    public void testNegativeNumbers(int input) {
        Assert.expectThrows(IllegalArgumentException.class, () -> {
            Factorial.multiplicationNumbers(input);
        });
    }

}
