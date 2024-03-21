package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GetPaidPage;

public class GetPaidPriceTest extends BaseTest
{
    @Test
    public void testReleaseALienPrice()
    {
        GetPaidPage getPaidPage = homePage.clickGetPaidBtn();
        Assert.assertEquals(getPaidPage.getElementPrice(),"$149");

    }

}
