import org.example.ComparingNumbers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComparingNumbersTest {
    @DataProvider(name = "comparingTest")
    public Object[][] comparingTest(){
        return new Object[][]{
                {0, 0, "Числа равны"},
                {-10, 10, "10 больше -10"},
                {50, -50, "50 больше -50"},
                {-100, -100, "Числа равны"},
                {500, 500, "Числа равны"}
        };
    }
    @Test(dataProvider = "comparingTest")
    public void testCompare(int inputOne, int inputTwo, String expected){
        String result = ComparingNumbers.compare(inputOne, inputTwo);
        Assert.assertEquals(result, expected);
    }
}
