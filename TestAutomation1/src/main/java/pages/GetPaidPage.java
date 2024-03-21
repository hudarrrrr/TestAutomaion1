package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GetPaidPage
{
    private WebDriver driver;
    public By price = By.xpath("//div[@class='left'][contains(.,'Release a Lien')]/following-sibling::div[@class='right panel-heading--price']/span[@class='price-amount']");

    public GetPaidPage(WebDriver driver)
    {
        this.driver = driver;
    }



    public String getElementPrice()
    {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(700));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(price)));
        return driver.findElement(price).getText();
    }


}
