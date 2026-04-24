import org.example.AreaTriangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AreaTriangleTest {
    @DataProvider(name = "triangle")
    public Object[][] triangle() {
        return new Object[][] {
                {10.0, 5.0, 25.0},
                {3.0, 4.0, 6.0},
                {7.0, 3.0, 10.5},
                {2.5, 4.0, 5.0},
                {0.0, 5.0, 0.0},
                {5.0, 0.0, 0.0}
        };
    }
    @Test(dataProvider = "triangle")
    public void triangleTest(double inputOne, double inputTwo, double expected){
        double result = AreaTriangle.area(inputOne, inputTwo);
        Assert.assertEquals(result, expected, 0.001);
    }
}