import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest
{
    LoginPage loginPage;

    InventoryPage inventoryPage;

    CheckOutStepOnePage checkOutStepOnePage;

    CartPage cartPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = browserOpen();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        loginPage.LoginOnPage();
    }
    @Test
    public void AddCartThreeProducts()
    {
        inventoryPage.sortProduct("Price (low to high)");
        Assert.assertEquals(inventoryPage.getPrice(),"$7.99");
        inventoryPage.clickSauceLabs();
        inventoryPage.clickLight();
        inventoryPage.clickBoltShirt();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");

    }

    @Test
    public void Totalprice()
    {
        inventoryPage.clickBoltShirt();
        inventoryPage.clickLight();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkOutStepOnePage.setForm("Vlada","Babic","11070");
        Assert.assertEquals(checkOutStepOnePage.getItemTotal(),"Item total: $25.98");
        Assert.assertEquals(checkOutStepOnePage.getTotal(),"Total: $28.06");
    }



   @Test
    public void BuyProductToTheEnd()
    {
        inventoryPage.clickBoltShirt();
        inventoryPage.clickLight();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkOutStepOnePage.setForm("Vlada","Babic","11070");
        checkOutStepOnePage.clickFinish();

        Assert.assertEquals(checkOutStepOnePage.getMessage(),"Thank you for your order!");

    }


    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
