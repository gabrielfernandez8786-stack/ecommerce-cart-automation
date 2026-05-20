package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(css=".cart_quantity") private List<WebElement> items;
    @FindBy(css=".cart_delete") private WebElement removeBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemCount() {
        return items.size();
    }

    public void removeItem() {
        removeBtn.click();
    }

    public boolean isCartEmpty() {
        return getItemCount() == 0;
    }
}
