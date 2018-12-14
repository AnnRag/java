import org.junit.Test;
import org.junit.Assert;
import personmarry.Person;

public class PersonTest {

    @Test
    public void Persontest() {
        Person woman = new Person(false, "Alice");
        Person suprug = new Person(true, "Aleksey");
        Person supruga = new Person(false, "Vera");
        //System.out.println(woman.marry(suprug));
        Assert.assertTrue(woman.marry(suprug));
        //System.out.println(woman.marry(supruga));
        Assert.assertFalse(woman.marry(supruga));
        //System.out.println(woman.divorce(suprug));
        Assert.assertTrue(woman.divorce(suprug));
        //System.out.println(woman.marry(suprug));
        Assert.assertTrue(woman.marry(suprug));
        //System.out.println(woman.marry(suprug));
        Assert.assertFalse(woman.marry(suprug));
        //System.out.println(woman.divorce(suprug));
        Assert.assertTrue(woman.divorce(suprug));
        //System.out.println(woman.divorce(suprug));
        Assert.assertFalse(woman.divorce(suprug));
    }
}