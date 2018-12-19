package BeanUtilsTest;

import beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestBean {

    //getter equals setter
    @Test
    public void TestBeanTrue(){
        FromTrue from = new FromTrue(1);
        ToTrue to = new ToTrue(2);

        BeanUtils.assign(to,from);
        Assert.assertEquals(to.getNumber(), 1);
    }

    //getter doesn't equal setter
    @Test
    public void TestBeanFalse(){
        FromFalse from = new FromFalse(1);
        ToFalse to = new ToFalse(2);

        BeanUtils.assign(to,from);
        Assert.assertEquals(to.getNumber(), 2);
    }
}
