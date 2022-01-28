package PageModel;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class ProductPage extends BaseMethods {
    String price;

    public static By productPrice = By.xpath("//span[@itemprop='price']");

    //span[@class='addToCartButton']
    //*[@id='addToCart' and @class='button big with-icon']
    //button[@id='addToCart']
    public static By addToCartBtn = By.xpath("//button[@id='addToCart']");
    public static By productQuantity = By.xpath("//input[@id='quantity']]");

    public static By minus = By.xpath("//button[@class='button effective icon icon-minus']");
    public static By plus = By.xpath("//button[@class='button effective icon icon-plus']");

    public static By searchResultSummary = By.xpath("//h1[@class='searchResultSummaryBar-bold']");

    public static By productBasketHeader = By.xpath("//span[@class='checkoutui-ProductOnBasketHeader-22Wrk']");
    public static By productBasketButton = By.xpath("//button[text()='Sepete git']");

    @Step("Seçilen üründen 2 adet sepete atılır.")
    public void addToCart() {
        switchToLastTab();

        price = findElement(productPrice).getText();
        scrollToElement();
        clickElement(driver.findElement(addToCartBtn));
        String text = findElement(productBasketHeader).getText();
        assertEquals(text, "Ürün sepetinizde");
        SpecDataStore.put("price",price);
    }
    @Step("Sepete gidilir.")
    public void goBasket(){
        clickElement(productBasketButton);
    }
}
