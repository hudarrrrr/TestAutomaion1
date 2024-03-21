package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    private By getPaidBtn = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn'][contains(.,'Get paid')]");
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public  GetPaidPage clickGetPaidBtn()
    {
        driver.findElement(getPaidBtn).sendKeys(Keys.ENTER);
        return new GetPaidPage(driver);
    }

}
