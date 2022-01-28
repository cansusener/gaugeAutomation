package PageModel;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class BasketPage extends BaseMethods{
    String quantity;
    public static By basketPrice = By.xpath("//div[@class='price_1D8UZ']");
    public static By basketQuantity = By.xpath("//input[@type='number']");
    public static By deleteProductButton = By.xpath("//a[@class='product_delete_1zR-0']");

    @Step("Sepete atılan ürünün fiyati karşılaştırılır")
    public void checkBasket() {
        String price = (String) SpecDataStore.get("price");
        String prc = getText(basketPrice);
        assertEquals(price, prc);
    }

    @Step("Ürün sepetten silinir.")
    public void deleteProductBasket() {
        clickElement(deleteProductButton);
    }

}
