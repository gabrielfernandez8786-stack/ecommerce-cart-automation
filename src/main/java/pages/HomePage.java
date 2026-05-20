package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    private WebElement searchBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openHome() {
        driver.get("https://automationexercise.com");
    }

    public void searchProduct(String name) {
        searchBox.sendKeys(name);
        searchBtn.click();
    }
}
