import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class TestCart
{
    private WebDriver driver;
    By userName = By.id("user-name");
    By password = By.id("password");

    By AddToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    By cart = By.id("shopping_cart_container");

    By login = By.id("login-button");
    String name = "standard_user";
    String pass = "secret_sauce";

    @Test
    public void testItem()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");

        //open login page and login
        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
        driver.findElement(userName).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).sendKeys(Keys.ENTER);

        //add item in cart
        String itemName= "Sauce Labs Fleece Jacket";
        String button="//div[text()='%s']/parent::a/parent::div/following-sibling::div/button";
        String itemButton=String.format(button,itemName);
        driver.findElement(By.xpath(itemButton)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //open the cart
        driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).click();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));

        String namelocator="//div[text()='%s']";
        String nameformat=String.format(namelocator,itemName);
        List<WebElement> itemList = driver.findElements(By.xpath(nameformat));
        //check if the item in the cart
        Assert.assertTrue(itemList.size()>0,"item doesn't exist");


    }

}
