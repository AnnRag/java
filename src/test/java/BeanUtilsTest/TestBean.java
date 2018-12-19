package BeanUtilsTest;

import beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestBean {

    @Test
    public void TestBean(){
        From from = new From(1);
        To to = new To(2);

        BeanUtils.assign(to,from);
        Assert.assertEquals(to.getNumber(), 1);
    }
}
