import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddElementToCart
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
    public void testDemo(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");

        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
        // System.out.println(loginPageHeader.getText());
        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs1","login page header does not match requirement");
        // driver.quit();

    }

    @Test
    public void addElemetToCart()
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

        //add the element to cart
        driver.findElement(AddToCartButton).sendKeys(Keys.ENTER);

        //make sure that the element is added to cart
        By elementsInCartNum = By.className("shopping_cart_badge");
        WebElement cartBadge = driver.findElement(elementsInCartNum);
        System.out.println(cartBadge.getText());
        Assert.assertEquals(cartBadge.getText(),"1","the cart is empty");


    }

}
