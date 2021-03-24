import org.junit.Assert;
import org.junit.Test;

public class TestCalculator2 {

    int num1 = 6;
    int num2 = 4;

    @Test
    public void testDoAddition2() {
        int expectedResult = 10;
        int actualResult = doAddition(num1, num2);

        Assert.assertEquals("TEST FAILED - Test Case #1", expectedResult, actualResult);
    }

    @Test
    public void testDoSubtraction2() {
        int expectedResult = 2;
        int actualResult = doSubtraction(num1, num2);

        Assert.assertEquals("TEST FAILED - Test Case #3", expectedResult, actualResult);
    }

    @Test
    public void testDoMultiplication2() {
        int expectedResult = 24;
        int actualResult = doMultiplication(num1, num2);

        Assert.assertEquals("TEST FAILED - Test Case #3", expectedResult, actualResult);
    }


    public int doAddition(int x, int y) {
        return x + y;
    }

    public int doSubtraction(int x, int y) {
        return x - y;
    }

    public int doMultiplication(int x, int y) {
        return x * y;
    }

}
