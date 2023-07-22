import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage
{
    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeBoltShirt;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeLight;



    public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickCheckout()
    {
        checkout.click();
    }




}
