package PageModel;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductListPage extends BaseMethods{

    List<WebElement> products;
    Random random = new Random();
    public static By productsList = By.xpath("//li[@class='productListContent-item']");

    @Step("Rastgele bir ürün seçilir")
    public void selectRandomProduct() {
        products = findElements(productsList);
        int productNumber = random.nextInt(products.size());
        clickElement(products.get(productNumber));
    }
}
