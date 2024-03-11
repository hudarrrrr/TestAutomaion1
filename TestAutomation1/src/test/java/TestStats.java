import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestStats
{
    //variables
    WebDriver driver;
    String url ="https://www.google.com.eg/";
    String searchWord="Test Automation";

    //locators
    By searchBar = By.name("q");
    By resultStats = By.id("result-stats");


    @Test
    public void testStatsAppear()
    {
        //to open the browser
        driver = new EdgeDriver();
        driver.get(url);
        driver.findElement(searchBar).sendKeys(searchWord);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);

        //to find the stats results on the located place on the page
        WebElement  resultElement = driver.findElement(resultStats);
        Assert.assertTrue(resultElement.isDisplayed());
        driver.close();
    }

    @Test
    public void testStatsValue()
    {
        //to open the browser
        driver = new EdgeDriver();
        driver.get(url);
        driver.findElement(searchBar).sendKeys(searchWord);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);

        //to validate if the stats results is 240000000
        WebElement  resultElement = driver.findElement(resultStats);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultElement.getText().contains("240000000"));
        softAssert.assertTrue(resultElement.getText().contains("1,030,000,000"));
        softAssert.assertAll();

        driver.close();

    }


}
