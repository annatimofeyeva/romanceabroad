package AlgosTest;

import com.romanceabroad.ui.Algos.SumElementsInArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sumElementsInArrayTest {

    // Unit test for sumElementsInArray
    @Test
    public void testSumElements() {
        SumElementsInArray sumElementsInArray = new SumElementsInArray();
        int array[] = {1, 5, -5, 10, 4};
        int expectedResult = 15;
        int actualResult = sumElementsInArray.sumElementsInArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Questions to interviewer: could the array be empty ?
    // Unit test for empty array:

    @Test
    public void testSumEmptyElements() {
        SumElementsInArray sumElementsInArray = new SumElementsInArray();
        int array[] = {};
        int expectedResult = 0;
        int actualResult = sumElementsInArray.sumElementsInArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSumOneElement() {
        SumElementsInArray sumElementsInArray = new SumElementsInArray();
        int array[] = {5};
        int expectedResult = 5;
        int actualResult = sumElementsInArray.sumElementsInArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
