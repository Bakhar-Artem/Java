package test.java;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.exception.DynArrayException;
import com.bakhar.entity.services.FindMaxMinValue;
import org.testng.Assert;
import org.testng.annotations.*;

public class FindMaxMinValueTest {
    int pos = 0;
    int pos2=0;
    private double[] answers = {1, 3, 0, 1, -1};
    private double[] answers2 = {1, 2., 0., 0., -26.};

    @Test(dataProvider = "Data",dataProviderClass = DataProvider.class)
    public void testFindMax(DynArray array) throws DynArrayException {
        Assert.assertEquals(answers[pos++], FindMaxMinValue.findMax(array));
    }


    @Test(dataProvider = "Data",dataProviderClass = DataProvider.class)
    public void testFindMin(Object[] arrays) throws DynArrayException {
        Assert.assertEquals(answers2[pos2++], FindMaxMinValue.findMin((DynArray) arrays[0]));
    }
}