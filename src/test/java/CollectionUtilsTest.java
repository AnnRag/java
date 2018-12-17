import collectionutils.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtilsTest {

    @Test
    public void CollectionUtilsTest(){
        List<Integer> list = new ArrayList<>();
        CollectionUtils.add(list, 3);
        CollectionUtils.add(list,4);
        Assert.assertTrue(list.contains(3));
        System.out.println(CollectionUtils.range(list,3,4));
        Assert.assertEquals(Arrays.asList(3,4),CollectionUtils.range(list,3,4));
    }
}
