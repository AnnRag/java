import countmap.CountMap;
import countmap.CountMapImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestCountMap {

    @Test
    public void TestCountMap(){
        CountMap<Integer> map = new CountMapImpl<Integer>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count1 = map.getCount(5); // 2
        int count2 = map.getCount(6); // 1
        int count3 = map.getCount(10); // 3

        Assert.assertEquals(count1, 2);
        Assert.assertEquals(count2, 1);
        Assert.assertEquals(count3, 3);

    }

}
