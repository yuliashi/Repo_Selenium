package Test1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFile {

    @Test
    public void verify3Plus3Is6() {
        Assert.assertEquals(3+3, 6, "3+3 is not coming as expected");
    }
}
