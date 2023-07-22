import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage
{
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement sauceLabs;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement light;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement boltShirt;


    @FindBy(className = "shopping_cart_badge")
    WebElement cart;


    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(className = "inventory_item_price")
    WebElement price;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickSauceLabs()
    {
        sauceLabs.click();
    }
    public void clickLight()
    {
        light.click();
    }
    public void clickBoltShirt()
    {
        boltShirt.click();
    }
    public String getCartNumber()
    {
        return cart.getText();
    }

    public void sortProduct(String text)
    {
        Select select = new Select(sort);
        select.selectByVisibleText(text);
    }

    public String getPrice()
    {
        return price.getText();
    }

    public void clickCart()
    {
        cart.click();
    }
}
