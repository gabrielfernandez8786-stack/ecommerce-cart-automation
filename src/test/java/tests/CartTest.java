package tests;
import pages.HomePage;
import pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    WebDriver driver;
    HomePage home;
    CartPage cart;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new HomePage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void testCartFlow() {
        home.openHome();
        home.searchProduct("T-Shirt");
        driver.get("https://automationexercise.com/view_cart");
        Assert.assertTrue(cart.getItemCount() >= 1, "Cart should have items");
        cart.removeItem();
        Assert.assertTrue(cart.isCartEmpty(), "Cart should be empty");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
